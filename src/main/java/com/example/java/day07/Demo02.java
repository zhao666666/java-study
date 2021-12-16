package com.example.java.day07;

/**
 * @Author: zhaojie
 * @Date: 2021/12/15 10:54
 * @Version: 1.0
 * @Description: 重写，参数一致，返回值一致
 */
public class Demo02 extends Demo01 {
    @Override
    public void buy() {
        super.buy();
    }


    public static void A(){

    }

    public static void main(String[] args) {
        Demo03 demo03 = new Demo03();
        Demo03 demo04 = new Demo03();

        Demo03.a();
        demo03.b();
        // 不应该通过类实例访问静态成员
       // demo04.a();
        demo04.b();
    }

}
