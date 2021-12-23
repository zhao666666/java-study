package com.example.java.day09;

import java.util.Objects;

/**
 * @Author: zhaojie
 * @Date: 2021/12/21 10:28
 * @Version: 1.0
 * @Description:
 */
public class FinalDemo {
    // final 修饰方法   方法不可以被重写
    // final 修饰形参   不可以在给形参赋值
    // final 修饰变量   不可以被复制，值不可以变
    private String b;
    public int count;
    private final String a = "5";

    public FinalDemo(String b, int count) {
        this.b = b;
        this.count = count;
    }

    public final void buy(int a){
        System.out.println("1111");
    }

    public void buy(final double b){
        // 不可以在给形参复制
        // b= 22;
        System.out.println("222");
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        final int [] b = {1,2,4,5,6};
        int[] c = {1,3};
        int[] d = {2,4};
        // final 修饰可以修改里面的引用的值，但是不能修改引用的数组
        // b = c;
        b[1] =2;
        c = d;
    }

    @Override
    @SuppressWarnings("")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FinalDemo)) {
            return false;
        }
        FinalDemo finalDemo = (FinalDemo) o;
        FinalDemo that = new FinalDemo(b, count);
        if(this.hashCode() == that.hashCode()){
            System.out.println(1111);
        };
        return Objects.equals(getA(), finalDemo.getA());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA());
    }

    @Override
    public String toString() {
        return "FinalDemo{" +
                "a='" + a + '\'' +
                '}';
    }
}
