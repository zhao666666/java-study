package com.example.java.day07;

import java.util.Scanner;

/**
 * @Author: zhaojie
 * @Date: 2021/12/15 19:39
 * @Version: 1.0
 * @Description:
 */
public class StringDemo {
    public static void main(String[] args) {
       double a =  Math.random();
       Scanner scanner = new Scanner(System.in);

       String b = "11123123_1231234_1231DFws";
        System.out.println(b.toLowerCase());
        System.out.println(b.toUpperCase());
        System.out.println(b.length());
        System.out.println(b);
        System.out.println(b.charAt(1));
        System.out.println(b.charAt(22));
        System.out.println(b.substring(5));
        // 左闭右开
        System.out.println(b.substring(1,5));
        String [] c = b.split("_");
        for (int i = 0; i <c.length; i++) {
            System.out.println(c[i]);
        }
        char[] d = b.toCharArray();
        for (int i = 0; i <d.length; i++){
            System.out.println(d[i]);
        }

        int indexOf = b.indexOf('_');
        System.out.println(indexOf);
        String substring = b.substring(indexOf+1, b.length()-1);
        System.out.println(substring);

        int lastIndexOf = b.lastIndexOf('_');
        System.out.println(lastIndexOf);

    }
}
