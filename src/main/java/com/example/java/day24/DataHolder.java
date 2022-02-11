package com.example.java.day24;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 10:21
 * @Version: 1.0
 * @Description:
 */
public class DataHolder {
    int a,b,c,d,f,g;
    //int e;
    // volatile 防止指令重排
     volatile int e;


    public void operatorDate(){
        // 按照这个顺序，g的值是肯定小于e的，但是在实际执行在执行的时候，可能会为了优化的目的重排
        a += 1;
        b += 1;
        c += 1;
        d += 1;

        e += 1;

        f += 1;
        g += 1;
    }

    int counter;

    public void check(){
        // 看似不可能，实际可能被触犯到
        if(g >e ){
            System.out.println("got it" + counter++);
        }
    }

}
