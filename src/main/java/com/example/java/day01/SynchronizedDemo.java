package com.example.java.day01;

/**
 * @Author: zhaojie
 * @Date: 2021/5/13 17:03
 * @Version: 1.0
 * @Description:
 */
public class SynchronizedDemo {
    private int x = 0;

    public void synBlock(){
        //1.加锁
        synchronized (SynchronizedDemo.class){
            // 对x赋值
            x = 1;
        }
        // 3.解锁
    }

    //1.加锁
    public synchronized void synMethod(){
        // 对x赋值
        x = 2;
    }
    // 3.解锁

}
