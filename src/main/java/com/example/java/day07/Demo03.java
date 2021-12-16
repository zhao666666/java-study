package com.example.java.day07;

/**
 * @Author: zhaojie
 * @Date: 2021/12/15 16:20
 * @Version: 1.0
 * @Description:
 */
public class Demo03 {
    private String a ;
    private String b ;
    private int c = 0;//999/0;
    private static int d;

    static{
        System.out.println("静态代码块");
        //int a = 999/0;
    }

    public Demo03(){
        //this.c = 999/0;
        System.out.println("构造方法");
    }

    public static void Demo03(){
        //this.c = 999/0;
        System.out.println("静态构造方法");
    }

    public static void a(){
        // 'com.example.java.day07.Demo03.this' cannot be referenced from a static context 不能从静态上下文中引用
        // this.a;
        d = 1;
        System.out.println("静态方法");
    }

    public void b(){
        d = 2;
        System.out.println("普通方法");
    }
}
