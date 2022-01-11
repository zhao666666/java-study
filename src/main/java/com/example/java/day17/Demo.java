package com.example.java.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: zhaojie
 * @Date: 2022/1/6 10:09
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("111");
        myList.add("aaa");
        myList.add("aaA");
        myList.add("aaA111");
        // FunctionalInterface
//        myList.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        myList.forEach(String::toUpperCase);

        myList.stream().filter(s->s.length() > 2).filter(s->s.length() < 4).map(String::toUpperCase).forEach(System.out::println);

//        myList.forEach(
//                (s) -> {
//                    System.out.println(s);
//                });

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.forEach((k,V)-> System.out.println());
        System.out.println("true".equals(Boolean.TRUE));

        System.out.println(Character.toUpperCase('a'));

    }
}
