package com.example.java.day03;

/**
 * @Author: zhaojie
 * @Date: 2021/12/3 21:08
 * @Version: 1.0
 * @Description:
 */
public class WhileDemo {
    public static void main(String[] args) {
        int i = 0;
        while (true){
           i++;
           System.out.println(i);
           if(i==10){
               break;
           }
        }
        /*do{
            System.out.println("do-while会执行一次");
        }while (false);*/
    }
}
