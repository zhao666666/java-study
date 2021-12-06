package com.example.java.day04;

/**
 * @Author: zhaojie
 * @Date: 2021/12/6 13:48
 * @Version: 1.0
 * @Description:
 */
public class ArrayDemo {
    public static void main(String[] args) {
        // 数组索引从0开始,连续的内存地址，数组的名是内存的第一个地址
        int [] intArray = new int[6];
        // intArray2 会新建地址，但是有值会指向数组内存的起始地址
        // 为什么数组从0开始，因为后面是一个偏移量，直接就可以取
        int [] intArray2 = {1,2,3,4};
        double []  a = new double[6];
        String[] string = new String[6];
        System.out.println(intArray2);
        System.out.println(intArray2[0]);
        System.out.println(intArray2[2]);


    }
}
