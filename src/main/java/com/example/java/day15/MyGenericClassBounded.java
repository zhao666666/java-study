package com.example.java.day15;

/**
 * @Author: zhaojie
 * @Date: 2022/1/4 15:33
 * @Version: 1.0
 * @Description:
 */
public class MyGenericClassBounded<E extends MyGenericClass>{
    private E e;

    public MyGenericClassBounded(E e) {
        // 可以调用MyGenericClass的方法
        e.getAnnotation("111");
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
