package com.example.java.day24;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 15:55
 * @Version: 1.0
 * @Description:
 */
public class WordLockDemo implements Runnable {
    private Lock lock;

    public WordLockDemo(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(lock.tryLock(1, TimeUnit.SECONDS)){
                    try {
                        printLockStatus("start");
                        process1();
                    } finally {
                        lock.unlock();
                        printLockStatus("finished");
                    }
                }else{
                    printLockFailure();   
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void process1() {
        try {
            lock.lock();
            printLockStatus("process1");
            process2();
        } finally {
            lock.unlock();
            printLockStatus("process1 finish");
        }
    }

    private void process2() {
        try {
            lock.lock();
            printLockStatus("process2");
            process3();
        } finally {
            lock.unlock();
            printLockStatus("process2 finish");
        }
    }

    private void process3() {
        try {
            lock.lock();
            printLockStatus("process3");
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            printLockStatus("process3 finish");
        }
    }

    private void printLockStatus(String phase) {
        System.out.println("Thread:" + Thread.currentThread().getName() +" " + phase +
                " hold count = " + ((ReentrantLock) lock).getHoldCount());
    }

    private void printLockFailure() {
        System.out.println(Thread.currentThread().getName() + "failed to get lock");
    }
}
