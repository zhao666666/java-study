package com.example.java.day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: zhaojie
 * @Date: 2021/5/10 15:45
 * @Version: 1.0
 * @Description:
 */
@Slf4j
public class Demo01 {
    private long count = 0;
    
    public   void  count(){
        int a = 0;
        while (a++<10000){
            count++;
        }

    }

    public  long getCount(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Demo01 demo = new Demo01();
        Thread thread1 = new Thread (demo::count,"线程1");
        Thread thread2 = new Thread (demo::count,"线程2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log.info("count的值="+demo.getCount());
    }

}
