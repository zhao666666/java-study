package com.example.java.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zhaojie
 * @Date: 2022/1/4 10:32
 * @Version: 1.0
 * @Description:
 */
public class GenericsDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        MyGenericClass<String, String> stringStringMyGenericClass1 = new MyGenericClass<>("111", "222");
        System.out.println(stringStringMyGenericClass1.getClass().getDeclaredField("first").getType());
        System.out.println(stringStringMyGenericClass1.getClass().getDeclaredField("second").getType());
        String a = stringStringMyGenericClass1.getFirst();
        System.out.println(stringStringMyGenericClass1.getFirst());


        MyGenericClass<String, Object> stringStringMyGenericClass2 = new MyGenericClass<>("111", "222");
        System.out.println(stringStringMyGenericClass2.getClass().getDeclaredField("first").getType());
        System.out.println(stringStringMyGenericClass2.getClass().getDeclaredField("second").getType());
        Object second = stringStringMyGenericClass2.getSecond();
        String annotation = stringStringMyGenericClass2.getAnnotation("111");

        List<? super Object> c = new ArrayList<Object>();
        c= Arrays.asList(new ArrayList<String>());


    }
}
