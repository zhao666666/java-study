package com.example.java.day01;

import java.util.stream.Stream;

/**
 * @Author: zhaojie
 * @Date: 2021/5/12 14:19
 * @Version: 1.0
 * @Description:
 */
public class StreamDemo {
    public static void main(String[] args) {
        Object[] res = Stream.of(1,2,3,4,5,6,7,8).filter(i->i%2==0).filter(i->i>2).toArray();
        System.out.println(res);
    }
}
