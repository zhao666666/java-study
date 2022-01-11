package com.example.java.day18;

import java.io.File;

/**
 * @Author: zhaojie
 * @Date: 2022/1/7 9:56
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        // java 可以根据不同的系统生成不同路径符号
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
    }
}
