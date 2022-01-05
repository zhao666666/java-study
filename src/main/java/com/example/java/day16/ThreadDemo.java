package com.example.java.day16;

/**
 * @Author: zhaojie
 * @Date: 2022/1/5 14:37
 * @Version: 1.0
 * @Description: t1,t2,t3三个线程，t1,t2同时进行，t3，t3等待t2再进行
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new ThreadT();
        t1.setName("t1");
        Thread t2 = new ThreadT();
        t2.setName("t2");
        Thread t3 = new ThreadT();
        t3.setName("t3");
        try {
            t1.start();
            t2.start();
            t2.join();
            t3.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class ThreadT extends Thread{
    @Override
    public void run() {
        System.out.println("线程名称为："+Thread.currentThread().getName());
    }
}
