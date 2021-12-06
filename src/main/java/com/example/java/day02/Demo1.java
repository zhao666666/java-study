package com.example.java.day02;

/**
 * @Author: zhaojie
 * @Date: 2021/11/24 15:55
 * @Version: 1.0
 * @Description:
 */

public class Demo1 {
    /**         byte(1byte = 8bit)      范围
     * byte     1                   -128~127
     * short    2                   -32768~32767
     * int      4                   -2147483648~214748647
     * long     8
     * float    4
     * double   8
     * boolean  1
     * char     2
     */
    public static void main(String[] args) {
        // -128~127
        byte byteVar = 99;
        System.out.println(byteVar);

        // -3w~3w
        short shortVar = -30000;
        System.out.println(shortVar);

        //~2,000,000,000~2,000,000,000
        int intVar = 2000000000;
        System.out.println(intVar);

        long longVar =  9999999999999L;
        System.out.println(longVar);

        float floatVar = 100.11111111f;
        System.out.println(floatVar);

        double doubleVar = 100.11111111;
        System.out.println(doubleVar);

        boolean booleanVar = false;
        System.out.println(booleanVar);

        char charVar = 'a';
        System.out.println(charVar);

        System.out.println((3+4)/5.0);
    }
}



