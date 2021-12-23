package com.example.java.day09;


/**
 * @Author: zhaojie
 * @Date: 2021/12/21 16:55
 * @Version: 1.0
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
        Object o = new Object();
        printObject(o);
    }

    private static void printObject(Object o) {
        System.out.println(o);
        System.out.println(o.toString());
        System.out.println(o.getClass());
        System.out.println(o.hashCode());
        System.out.println("".equals(o));

        String s1 = "1111";
        String s2 = "11"+"11";
        String s3 = new String("1111");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        FinalDemo finalDemo = new FinalDemo("111", 1);
        System.out.println(finalDemo.toString());

    }

    /**
     *  equals为true，hashCode就应该相等，这是一个约定俗成的规范
     *  equals为true是hashCode相等的充分非必要条件，hashCode相等是equals为true的必要不充分条件
     */

    /*@Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }*/

    // 当string比较短的时候，会从堆中去查找string创建对象，所以==为true，当string很长时为false
}
