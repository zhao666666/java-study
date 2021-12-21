package com.example.java.day08;

/**
 * @Author: zhaojie
 * @Date: 2021/12/20 17:28
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    private String name;
    private String addr;
    private int age;

    public Demo(){
        System.out.println("无参构造方法");
    }

    public Demo(String name,String addr,int age){
        this.name = name;
        this.addr = addr;
        this.age = age*3;
    }

    public String getName() {
        return this.name + "地址：" + this.addr + "年龄：" + this.age;
    }
}
