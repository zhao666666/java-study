package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 15:50
 * @Version: 1.0
 * @Description: 延迟显示文字
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        String a = "1234567890qwertyuiopasd\n......";
        printSlowly(a,300);
    }

    private static void printSlowly(String a, int i) throws InterruptedException {
        for(char c:a.toCharArray()){
            Thread.sleep(i);
            System.out.print(c);
        }
    }
}
