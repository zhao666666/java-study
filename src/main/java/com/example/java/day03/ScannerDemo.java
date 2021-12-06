package com.example.java.day03;

import java.util.Scanner;

/**
 * @Author: zhaojie
 * @Date: 2021/12/3 22:04
 * @Version: 1.0
 * @Description: 猜数字游戏
 */
public class ScannerDemo {
    public static void main(String[] args) {
        //o - 100
        Scanner scanner = new Scanner(System.in);
        // 游戏设置
        System.out.println("请输入随机数的范围，正整数");
        System.out.println("请输入最小值");
        int min = scanner.nextInt();
        System.out.println("请输入最大值");
        int max = scanner.nextInt();
        System.out.println("设置最大猜测次数");
        int maxCount = scanner.nextInt();

        // 生成随机数
        int random = (int) (Math.random()*(max-min+1)+min);
        System.out.println(random);
        // 计数
        int count = 0;
        System.out.println("游戏开始");
        while(true){
            count++;
            if(count > maxCount){
                System.out.println("输入次数过大,随机数为"+random);
                break;
            }
            System.out.println("输入范围"+min+"到"+max+"，剩余次数"+(maxCount-count));
            int a = scanner.nextInt();
            if(random==a){
                System.out.println("恭喜你猜对了");
                break;
            }else if(a<min || a>max){
                System.out.println("输入范围错误，失败次数加一");
                continue;
            }else{
                System.out.println("输入错误，失败次数加一");
            }
        }


    }
}
