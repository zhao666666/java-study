package com.example.java.day23;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 14:07
 * @Version: 1.0
 * @Description:
 */
public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        AppResources appResources = new AppResources();
        Thread t1 = new Thread(new Task1(appResources),"Thead-Task1");
        Thread t2 = new Thread(new Task2(appResources),"Thead-Task2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("程序结束");
    }
}
