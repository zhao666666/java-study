package com.example.java.day10;

import java.lang.annotation.*;

/**
 * @Author: zhaojie
 * @Date: 2021/12/22 22:16
 * @Version: 1.0
 * @Description:
 */
@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited  //可以继承
public @interface SubAnnotation {

}