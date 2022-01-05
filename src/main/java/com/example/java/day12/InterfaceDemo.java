package com.example.java.day12;

/**
 * @Author: zhaojie
 * @Date: 2021/12/24 11:22
 * @Version: 1.0
 * @Description:
 */
public interface InterfaceDemo {
    void add();

    /**
     * 接口方法必须用static修饰
     */
    static void update(){
        System.out.println("1111");
    }

    default int delete(int age){
        String a = "11";
        System.out.println("22222");
        return 0;
    }

    // java 9接口中可以定义私有方法
    /*private long delete(){
        return 0;
    }*/


}
