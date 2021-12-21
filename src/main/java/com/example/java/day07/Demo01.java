package com.example.java.day07;

/**
 * @Author: zhaojie
 * @Date: 2021/12/15 10:52
 * @Version: 1.0
 * @Description: 重载，参数不一样
 * 方法签名：是一个方法再一个类中的唯一标识；方法名+依次参数类型
 * buy (int a)
 * buy (int a,int b)
 * 构造方法，方法名跟类名一样，Demo01，没有返回值
 */
public class Demo01 {

    protected void buy(){
        System.out.println("父类");
    }

    private static void A(){

    }

    public static void A(int a){

    }

    /*public static int A(int a){
        return 1;
    }*/

    private void Demo01(){

    }


    public void buy(int a){

    }

   /* public int buy(int a){
        return 1;
    }*/

    public int buy(int a, int b) {
        return 1;
    }
}
