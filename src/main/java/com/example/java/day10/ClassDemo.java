package com.example.java.day10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: zhaojie
 * @Date: 2021/12/22 14:08
 * @Version: 1.0
 * @Description:
 */
@SubAnnotation
public class ClassDemo {
    // ...语法糖，可以变化参数个数
    public static void main(String... args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FinalDemo finalDemo = new FinalDemo("!11", 1);
        Class clazz = FinalDemo.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        // getField当成员变量属性是private时，会抛异常,getDeclaredField可以获取private私有的类，不会抛异常
        Field count = clazz.getField("count");
        Field b = clazz.getDeclaredField("b");
        System.out.println(count.getType());
        System.out.println(b.getType());
        System.out.println(count.getName());
        System.out.println(b.getName());
        b.setAccessible(true);


        finalDemo.setB("111");
        Method bMethod = clazz.getDeclaredMethod("getB");
        bMethod.setAccessible(true);
        Object value = bMethod.invoke(finalDemo);
        System.out.println(value.toString());

        Field abc = clazz.getDeclaredField("b");
        abc.setAccessible(true);
        abc.set(finalDemo,1111);
        System.out.println("==============>"+b.get(finalDemo));

        //System.out.println(o.toString());



        Method equalsDemo = clazz.getDeclaredMethod("equals",Object.class);
        System.out.println(equalsDemo.getAnnotatedReturnType());
        System.out.println(Arrays.toString(equalsDemo.getAnnotations()));

        Annotation annotation = clazz.getAnnotation(SubAnnotation.class);
        System.out.println(annotation);

        //Method setB = clazz.getDeclaredMethod("setB", int.class);

    }
}
