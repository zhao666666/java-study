package com.example.java.day01;

/**
 * @Author: zhaojie
 * @Date: 2021/5/17 14:19
 * @Version: 1.0
 * @Description:
 */
public class JoinDemo {
    int x = 0;
    int y = 1;
    boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo::writer);
        thread.start();
        thread.join();
        System.out.println("x:"+joinDemo.x);
        System.out.println("y:"+joinDemo.y);
        System.out.println("flag:"+joinDemo.flag);
        System.out.println("主线程结束");
    }

    public void writer(){
        this.x = 10;
        this.y = 20;
        this.flag = true;
    }
}
