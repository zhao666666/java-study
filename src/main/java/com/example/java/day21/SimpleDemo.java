package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 17:37
 * @Version: 1.0
 * @Description:
 */
public class SimpleDemo {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        ChangeData increment = new ChangeData(2,Integer.MAX_VALUE/2,dataHolder);
        increment.run();
        ChangeData decrement = new ChangeData(-2,Integer.MAX_VALUE/2,dataHolder);
        decrement.run();
    }
}
