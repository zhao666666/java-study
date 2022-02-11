package com.example.java.day24;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 10:28
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(1);
        /*DataHolder dataHolder = new DataHolder();
        Thread operatorDate = new Thread(()->{
           while (true){
               dataHolder.operatorDate();
           }
        });

        operatorDate.start();

        Thread check = new Thread(()->{
            while (true){
                dataHolder.check();
            }
        });

        check.start();*/
        System.out.println(tryDemo());
    }

    private static int tryDemo() {
        try {
            int a = 1/0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
           return 2;
        } finally {
            return 3;
        }


    }
}
