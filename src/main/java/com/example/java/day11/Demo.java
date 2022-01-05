package com.example.java.day11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhaojie
 * @Date: 2021/12/23 11:15
 * @Version: 1.0
 * @Description:
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //Class clazz1 = Class.forName("User");
        Class clazz = User.class;
        //Class clazz3 = new User().getClass();

        User user = new User();
        Field name = clazz.getField("name");
        System.out.println(name.get(user));

        name.set(user,"赵杰");
        System.out.println(name.get(user));

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);

        System.out.println(age.get(user));
        age.set(user,12);
        System.out.println(age.get(user));
        System.out.println(user.getAge());

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName());
        }

        Method getName = clazz.getMethod("getName");
        Object o = getName.invoke(user);
        System.out.println(o.toString());
        System.out.println(o);


        System.out.println(EnumDemo.SUCCESS);
        System.out.println(EnumDemo.SUCCESS.getId());
        for (EnumDemo value : EnumDemo.values()) {
            System.out.println(value);
        }
        System.out.println(EnumDemo.valueOf("SUCCESS"));

        // 枚举可以用set方法，本质也是实例
        EnumDemo.SUCCESS.setId(22);
        System.out.println(EnumDemo.SUCCESS.getId());

        long l = System.currentTimeMillis();

        ClassDemo classDemo = new ClassDemo();
        InterfaceDemo interfaceDemo = classDemo;
        System.out.println(interfaceDemo.update());
    }
}
