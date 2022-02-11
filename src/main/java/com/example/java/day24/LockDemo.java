package com.example.java.day24;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 16:13
 * @Version: 1.0
 * @Description:
 */
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new WordLockDemo(lock),"Work-"+i);
            t.start();
        }
    }
}
