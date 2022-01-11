package com.example.java.day17;

import java.util.function.Function;

/**
 * @Author: zhaojie
 * @Date: 2022/1/6 17:15
 * @Version: 1.0
 * @Description:
 */
public class LamdbaDemo {
    public static void main(String[] args) throws Exception {
        String s = randomData(String::valueOf);
        System.out.println(s);

        String s1 = rendomDataWithExceptionHandling(String::valueOf);
        System.out.println(s1);
    }

    // 有数据，代码
    public static String randomData(Function<Object,String> converter){
        return converter.apply(Math.random());
    }

    // lambda 如果有checkException 异常，那么接口必须允许，在调用的地方，只要正常处理异常就可以了
    public static String rendomDataWithExceptionHandling(ExceptionLambda<Object,String> converter) throws Exception {
        return converter.hasException(Math.random());
    }

}

interface ExceptionLambda<P,R>{
    R hasException(P p) throws Exception;
}

