package com.example.java.day24;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 16:16
 * @Version: 1.0
 * @Description:
 */
public class LockWaitNotifyAll {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread thread = new Thread(()->{
                System.out.println(finalI);
                countDownLatch.countDown();
            },"Thead name " +i);

            thread.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }
}
