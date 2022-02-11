package com.example.java.day24;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 14:47
 * @Version: 1.0
 * @Description:
 */
public class AtomicLongDemo {
    AtomicLong atomicLong = new AtomicLong(0);
    private volatile long longVar = 0;

    public static void main(String[] args) throws InterruptedException {
        AtomicLongDemo atomicLong = new AtomicLongDemo();
        int loop = Integer.MAX_VALUE / 10;

        int parallel = 10;
        List<Thread> atomicThreads = new ArrayList<>();
        for (int j = 0; j < parallel; j++) {
            int loopCount = loop / parallel;
            if (j == parallel - 1) {
                loopCount = loop - (loop / parallel) * (parallel - 1);
            }
            int finalLoopCount = loopCount;
            Thread atomic = new Thread(()->{
               long start = System.currentTimeMillis();
                for (int i = 0; i < finalLoopCount; i++) {
                    atomicLong.atomicLong.incrementAndGet();
                }
                System.out.println("atomic takes " + (System.currentTimeMillis() -start));
            });

            atomic.start();
            atomicThreads.add(atomic);
        }

        Thread primary = new Thread(()->{
           long start = System.currentTimeMillis();
            for (int i = 0; i < loop; i++) {
                atomicLong.longVar++;
            }
            System.out.println("primary var takes "+(System.currentTimeMillis()-start));
        });
        primary.start();
        for (Thread atomicThread : atomicThreads) {
            atomicThread.join();
        }
        primary.join();

        System.out.println(atomicLong.toString());
    }

    @Override
    public String toString() {
        return "AtomicLongDemo{" +
                "atomicLong=" + atomicLong +
                ", longVar=" + longVar +
                '}';
    }
}
