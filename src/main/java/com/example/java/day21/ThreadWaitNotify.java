package com.example.java.day21;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 18:45
 * @Version: 1.0
 * @Description:
 */
public class ThreadWaitNotify {
    public static void main(String[] args) {
        Object o = new Object();
        int workingSec = 2;
        int threadCount = 5;
        Executor executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                System.out.println(getName() + "线程开始工作");
                try{
                    // synchronzied 不是公平锁
                    synchronized(o){
                        System.out.println(getName() + "进入等待");
                        sleepSec(workingSec);
                        System.out.println(getName() + "线程进行");
                        sleepSec(workingSec);
                        System.out.println(getName() + "线程结束");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            },"工作线程"+i).start();

            System.out.println("===================唤醒线程开始sleep");
            sleepSec(workingSec-1);
            System.out.println("唤醒线程sleep结束");
            synchronized(o){
                System.out.println("===================================开始唤醒所有");
                o.notifyAll();
            }
        }
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }

    private static void sleepSec(int workingSec) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(workingSec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
