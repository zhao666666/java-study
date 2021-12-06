package com.example.java.day03;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zhaojie
 * @Date: 2021/12/3 21:51
 * @Version: 1.0
 * @Description:
 */
public class RandomDemo {
    private static final Logger LOG = LoggerFactory.getLogger(RandomDemo.class);

    public static void main(String[] args) {

        int b = 50;
        while(b>40 && b<100){
            double a = Math.random();

            b = (int)(a*59)+41;
            LOG.info("b{}",b);
        }
    }
}
