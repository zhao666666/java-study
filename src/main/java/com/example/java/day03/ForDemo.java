package com.example.java.day03;

/**
 * @Author: zhaojie
 * @Date: 2021/12/3 19:15
 * @Version: 1.0
 * @Description:
 */
public class ForDemo {
    public static void main(String[] args) {
        A:
        for (int i = 1; i < 10; i++) {
            String a = "";
            B:
            for (int j = 1; j < 10; j++) {
                if (j > i) {
                    break;
                }
                a += i + "*" + j + "=" + (i * j) + "\t";
            }
            System.out.println(a);
        }
    }
}
