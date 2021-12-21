package com.example.java.day08;

/**
 * @Author: zhaojie
 * @Date: 2021/12/20 17:28
 * @Version: 1.0
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01("1","2",3);
        System.out.println(demo01.getName());

        Demo01 demo011 = new Demo01();
        System.out.println(demo01);
        Demo demo = new Demo();
        // 父类可以直接赋值子类
        demo = demo01;
        // 父类赋值子类需要强转
        demo011 = (Demo01) demo;
        if( demo011 instanceof Demo){
            System.out.println("1111");
        }else{

        }
    }
}
