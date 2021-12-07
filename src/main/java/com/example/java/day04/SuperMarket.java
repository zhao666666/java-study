package com.example.java.day04;

/**
 * @Author: zhaojie
 * @Date: 2021/12/6 19:00
 * @Version: 1.0
 * @Description:
 */
public class SuperMarket {
    public static void main(String[] args) {
        Shop shop1 = new Shop();
        shop1.name = "可口可乐";
        shop1.count = 1;
        System.out.println(shop1.count);
        System.out.println(shop1.price);
        System.out.println(shop1);

        Shop[] shops = new Shop[3];
        System.out.println(shops[0]);
        //java.lang.NullPointerException 空指针异常
       if(shops[0].name == ""){
           System.out.println(111);
       }

    }
}
