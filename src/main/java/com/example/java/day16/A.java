package com.example.java.day16;

import java.lang.annotation.Documented;

/**
 * @Author: zhaojie
 * @Date: 2022/1/5 14:09
 * @Version: 1.0
 * @Description:
 */
@AnnotationDemo(defaultValue = "111", targetClass = A.class, a = 1, defaultValues = "111")
public class A {
    ReaderA rederA;
    WriterA writerA;

}
