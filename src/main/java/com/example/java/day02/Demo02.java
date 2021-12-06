package com.example.java.day02;

import java.util.Scanner;

/**
 * @Author: zhaojie
 * @Date: 2021/11/30 15:10
 * @Version: 1.0
 * @Description: 布尔运算符
 */
public class Demo02 {
    /**
     *  ！
     *  &
     *  &&
     *  |
     *  ||
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * 16进制转10进制
         */
        /*while (scanner.hasNext()) {
            String changeVar = scanner.next().substring(2);
            System.out.println(Integer.valueOf(changeVar,16).toString());
        }*/
        // 1111 1000
        int a = 0xF8;
        // 1111 0100
        int b = 0xF4;
        // 1111 1111
        int c = 0xFF;
        /**
         * 按位并 & 都是1才是1
         * 1111 1000
         * 1111 0100
         * 1111 0000
         */
        System.out.println(a & b);
        /**
         * 按位或 | 只要有1就是1
         * 1111 1000
         * 1111 0100
         * 1111 1100
         */
        System.out.println(a | b);
        /**
         * 按位异或^ 只要不一样就是1，一样就是0
         * 1111 1000
         * 1111 0100
         * 0000 1100
         */
        System.out.println(a ^ b);
        /**
         * 按位取反~    第一位是符号位,0是整数，1是负数
         * 1111 1111  取反
         *
         */
        System.out.println(~c);
        System.out.println(Integer.valueOf("FF",16));

        /**
         * 位移运算符
         * >>:符号位不动，其余位右移，符号位后边补0，又称带符号右移   高效 /2
         * >>>:符号位一起右移，左边补0，又称无符号右移
         * <<:左移，右边补0。左移没有带符号一说，因为符号位在最左侧   高效 *2
         * 一般用于
         */
        // 0100 0000 0000
        int x = 0x400;
        System.out.println("========================");
        // 0010 0000 0000
        System.out.println(x >> 1);
        // 0001 0000 0000
        System.out.println(x >> 2);

        // 1000 0000 0000
        System.out.println(x << 1);
        // 0001 0000 0000 0000
        System.out.println(x << 2);
        // 1100 0000 0000
        int y = -0x400;
        System.out.println(y >> 1);
        System.out.println(y >> 2);

        System.out.println(y << 1);
        System.out.println(y << 2);

        System.out.println(y >>> 1);
        System.out.println(y >>> 2);

    }
}
