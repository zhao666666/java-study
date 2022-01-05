package com.example.java.day16;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: zhaojie
 * @Date: 2022/1/5 16:02
 * @Version: 1.0
 * @Description:
 */
// 指明注解可以用在哪
@Target({ElementType.TYPE,ElementType.METHOD})
// 注解会留存到哪阶段
@Retention(RetentionPolicy.RUNTIME)

// 定义一个自己的annotation，需要@interface，实际上这个接口会继承Annotation接口
public @interface AnnotationDemo{
    // 指定默认值
    String defaultValue() default "N/A";

    Class targetClass();

    int a();

    String[] defaultValues();

    // 注解类型的缺省值
    Override is() default @Override;

}
