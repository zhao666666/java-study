package com.example.java.day08;

/**
 * @Author: zhaojie
 * @Date: 2021/12/20 17:36
 * @Version: 1.0
 * @Description:
 */
public class Demo01 extends Demo{

    /**
     *  都是<init>方法
     *  super调用构造方法，不可以使用super访问父类的属性和方法，不可以使用子类成员变量和方法
     * @param name
     * @param addr
     * @param age
     */
    public Demo01(String name, String addr, int age) {
        super(name, addr, age);
        init();
    }
    public Demo01() {
        super();
        init();
    }

    public void init(){

    }
}
