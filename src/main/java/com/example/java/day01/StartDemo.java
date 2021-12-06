package com.example.java.day01;

/**
 * @Author: zhaojie
 * @Date: 2021/5/17 14:19
 * @Version: 1.0
 * @Description:
 */
public class StartDemo {
    int x = 0;
    int y = 1;
    boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        StartDemo startDemo = new StartDemo();
        Thread thread = new Thread(startDemo::writer);
        System.out.println("x:"+startDemo.x);
        System.out.println("y:"+startDemo.y);
        System.out.println("flag:"+startDemo.flag);
        System.out.println("主线程结束");
    }

    public void writer(){
        this.x = 10;
        this.y = 20;
        this.flag = true;
    }
}
