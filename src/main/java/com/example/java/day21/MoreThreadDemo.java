package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 17:46
 * @Version: 1.0
 * @Description:
 */
public class MoreThreadDemo {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        DataHolder dataHolder1 = new DataHolder();
        Thread increment = new Thread(new ChangeData(2,Integer.MAX_VALUE/100,dataHolder));
        Thread decrement = new Thread(new ChangeData(-2,Integer.MAX_VALUE/100,dataHolder1));
        //Thread increment1 = new Thread(new ChangeData(-2,Integer.MAX_VALUE/100,dataHolder1));

        increment.start();
        decrement.start();
        //increment1.start();

    }
}
