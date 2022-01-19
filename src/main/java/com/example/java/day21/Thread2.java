package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 18:29
 * @Version: 1.0
 * @Description:
 */
public class Thread2 implements Runnable {
    @Override
    public void run() {

//		SynchronizedTest s = SynchronizedTest.getInstance();
//		SynchronizedTest s2 = new SynchronizedTest();
//		s2.method1();
//		s.method2();
//		SynchronizedTest.staticMethod1();
//		SynchronizedTest.staticMethod2();
//		SynchronizedTest.staticIn.method2();
        SynchronizedTest.staticMethod1();
    }
}
