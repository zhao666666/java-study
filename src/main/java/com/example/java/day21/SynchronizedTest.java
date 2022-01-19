package com.example.java.day21;

import lombok.Data;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 18:29
 * @Version: 1.0
 * @Description:
 */
@Data
public class SynchronizedTest {
    public static SynchronizedTest staticIn = new SynchronizedTest();   //静态对象


    public synchronized void method1(){                                      //非静态方法1
        for(int i = 0;i < 10;i++){
            System.out.println("method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized void method2(){                                   //非静态方法2
        for( int i = 0; i < 10 ; i++){
            System.out.println("method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized static void staticMethod1(){                     //静态方法1
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public synchronized static void staticMethod2(){                      //静态方法2
        for( int i = 0; i < 10 ; i++){
            System.out.println("static method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
