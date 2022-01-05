package com.example.java.day15;

/**
 * @Author: zhaojie
 * @Date: 2022/1/4 10:55
 * @Version: 1.0
 * @Description:
 */
public class MyGenericClass<First,Second> {
    private First first;

    private Second second;

    public MyGenericClass(First first, Second second) {
        this.first = first;
        this.second = second;
    }


    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }

    public <E> E getAnnotation(Object val){
        return (E) val;
    }
}
