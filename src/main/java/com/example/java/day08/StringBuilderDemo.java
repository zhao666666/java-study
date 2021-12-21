package com.example.java.day08;

/**
 * @Author: zhaojie
 * @Date: 2021/12/20 14:48
 * @Version: 1.0
 * @Description:
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("111").append("abd123").append("_111231");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.reverse().toString());
        System.out.println(stringBuilder.reverse().toString());
    }
}
