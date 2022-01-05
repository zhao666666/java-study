package com.example.java.day11;

/**
 * @Author: zhaojie
 * @Date: 2021/12/23 11:12
 * @Version: 1.0
 * @Description:
 */
public class User {
    public String name;
    private int age;

    public void ageAndName(String name,int age) {
        System.out.println("不告诉你");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
