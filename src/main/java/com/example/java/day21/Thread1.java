package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 18:29
 * @Version: 1.0
 * @Description:
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {

		//SynchronizedTest s = SynchronizedTest.getInstance();
		//s.method1();
		SynchronizedTest s1 = new SynchronizedTest();
		s1.method1();
        SynchronizedTest.staticIn.method1();

//		SynchronizedTest.staticMethod1();
//		SynchronizedTest.staticMethod2();
    }
}
