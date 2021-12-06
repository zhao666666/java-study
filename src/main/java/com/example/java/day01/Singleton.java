package com.example.java.day01;

/**
 * @Author: zhaojie
 * @Date: 2021/5/10 17:39
 * @Version: 1.0
 * @Description:
 */
public class Singleton {
    static volatile Singleton instance;

    public Singleton() { }

    public
    static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
