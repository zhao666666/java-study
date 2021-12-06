package com.example.java.day02;

/**
 * @Author: zhaojie
 * @Date: 2021/11/30 15:06
 * @Version: 1.0
 * @Description: 字符串常量池
 */
public class StringCompare {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = new String("1");
        s2 = s2.intern();
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
    }
}
