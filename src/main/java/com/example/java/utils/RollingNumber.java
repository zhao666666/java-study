package com.example.java.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhaojie
 * @Date: 2021/12/24 17:17
 * @Version: 1.0
 * @Description: 基于滑动窗口统计的qps、最大qps方法工具
 */
public class RollingNumber {

    private int bucketNum;

    /**
     * 槽组
     */
    private Bucket[] buckets;

    /**
     * 时间片
     */
    private long bucketTimeSlice;


    /**
     * 目标槽位下标
     */
    private volatile Integer targetBucketPosition;

    /**
     * 临界跨槽时的时间点
     */
    private volatile long lastPassTimeCloseToTargetBucket;

    /**
     * 刷新槽位时使用的锁
     */
    private ReentrantLock enterNextBucketLock;


    /**
     * 固定窗口的最大qps
     */
    private volatile long maxSummary;

    private RollingNumber() {
        this(60, 1000);
    }

    private RollingNumber(int bucketNum, int millerSecond) {
        this.bucketNum = bucketNum;
        buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        this.bucketTimeSlice = millerSecond;
        enterNextBucketLock = new ReentrantLock();
        this.lastPassTimeCloseToTargetBucket = System.currentTimeMillis() - (2 * bucketTimeSlice);
        maxSummary = 0;
    }

    /**
     * 默认60个槽位，槽位的时间片为1000毫秒
     */
    public static RollingNumber create() {
        return new RollingNumber();
    }

    public static RollingNumber create(int bucketNum, int millerSecond) {
        return new RollingNumber(bucketNum, millerSecond);
    }


    /**
     * 槽值滑动统计
     *
     * @return
     */
    public long summary() {
        long time = System.currentTimeMillis();
        int currentBucketIndex = (int) (time / bucketTimeSlice) % bucketNum;
        /*
         * qps统计后 lastPassTimeCloseToTargetBucket 会逐步趋近到槽界界点
         */
        long qps = 0;
        if (time - lastPassTimeCloseToTargetBucket >= bucketTimeSlice) {
            //是0忽略
        } else {
            int lastIndex = currentBucketIndex == 0 ? bucketNum - 1 : currentBucketIndex - 1;
            long duration = (time - lastPassTimeCloseToTargetBucket) % bucketTimeSlice;
            long slideCount = (long) (buckets[lastIndex].sum() * ((bucketTimeSlice - duration) % bucketTimeSlice) * 0.001);
            long currentSum = buckets[currentBucketIndex].sum();
            qps = slideCount + currentSum;
        }
        return qps;
    }

    /**
     * 历史最大槽值统计
     *
     * @return
     */
    public long getMaxSummary() {
        if (maxSummary == 0) {
            return summary();
        }
        return maxSummary;
    }

    /**
     * 清理历史记录
     */
    public void clearMaxSummary() {
        enterNextBucketLock.lock();
        try {
            maxSummary = 0;
        } finally {
            enterNextBucketLock.unlock();
        }
    }

    /**
     * 计数
     */
    public void click() {
        long passTime = System.currentTimeMillis();
        if (targetBucketPosition == null) {
            targetBucketPosition = (int) (passTime / bucketTimeSlice) % bucketNum;
        }
        Bucket currentBucket = buckets[targetBucketPosition];
        if (passTime - lastPassTimeCloseToTargetBucket >= bucketTimeSlice) {
            if (enterNextBucketLock.isLocked()) {
                //忽略跳过
            } else {
                enterNextBucketLock.lock();  //可以尝试用tryLock
                try {
                    if (passTime - lastPassTimeCloseToTargetBucket >= bucketTimeSlice) {
                        int nextTargetBucketPosition = (int) (passTime / bucketTimeSlice) % bucketNum;
                        Bucket nextBucket = buckets[nextTargetBucketPosition];
                        if (!nextBucket.equals(currentBucket)) {
                            //跨槽
                            long summary = buckets[targetBucketPosition].sum();
                            if (summary > maxSummary) {
                                maxSummary = summary;
                            }
                            nextBucket.reset(passTime);
                            //目标槽位变动
                            targetBucketPosition = nextTargetBucketPosition;
                        }
                        lastPassTimeCloseToTargetBucket = passTime;
                        nextBucket.incr();
                        return;
                    } else {
                        currentBucket = buckets[targetBucketPosition];
                    }
                } finally {
                    enterNextBucketLock.unlock();
                }
            }
        } else {
            //没到接近跨槽临界值
        }
        currentBucket.incr();
    }

    private static final class Bucket {
        /**
         * 槽内计数器
         */
        private LongAdder adder;

        /**
         * 第一次时间，只记录一次
         */
        private long firstPassTime;

        public Bucket() {
            adder = new LongAdder();
            firstPassTime = System.currentTimeMillis();
        }

        /**
         * 计数
         */
        public void incr() {
            adder.increment();
        }

        /**
         * 重制
         */
        public void reset(long time) {
            adder.reset();
            firstPassTime = time;
        }

        /**
         * 统计
         *
         * @return
         */
        public long sum() {
            return adder.sum();
        }

        public long getFirstPassTime() {
            return firstPassTime;
        }

        public long sumThenReset() {
            return adder.sumThenReset();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        RollingNumber rollingNumber = new RollingNumber();
        int threadNum = 10;
        int rollingCnt = 3000;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        List<Thread> threadList = new ArrayList<Thread>();
        Random random = new Random();
        for (int i = 0; i < threadNum; i++) {
            threadList.add(new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < rollingCnt; i++) {
                        //这里可以适当增加随机延时看效果
//                        try {
//                            TimeUnit.MILLISECONDS.sleep(2L);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        rollingNumber.click();
                    }
                    countDownLatch.countDown();
                }
            });
        }

        long startTime = System.currentTimeMillis();
        for (Thread thread : threadList) {
            thread.start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("totalMilliseconds:  " + totalTime);
        System.out.println("current qps is " + rollingNumber.summary());
        System.out.println("max qps is " + rollingNumber.getMaxSummary());
    }

}