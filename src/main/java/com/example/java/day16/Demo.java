package com.example.java.day16;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaojie
 * @Date: 2022/1/5 15:51
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String,String>(16);
        hashMap.put(null,"111");
        hashMap.put(null,"222");
        hashMap.put("111",null);
        hashMap.put("222",null);

        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get("111"));
        System.out.println(hashMap.get("222"));

        for(String key : hashMap.keySet()){
            System.out.println(key);
        }
        System.out.println("=======================");
        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            System.out.println(stringStringEntry.getKey() + "=" + stringStringEntry.getValue());
        }
        System.out.println("=======================");
        for (String value : hashMap.values()) {
            System.out.println(value);
        }

        Class<A> clazz = A.class;
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(annotation.annotationType());
        }

        AnnotationDemo  annotation = clazz.getAnnotation(AnnotationDemo.class);
        System.out.println(annotation);
        System.out.println(annotation.a());

    }
}
