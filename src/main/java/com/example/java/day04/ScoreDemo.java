package com.example.java.day04;

import java.util.Scanner;

/**
 * @Author: zhaojie
 * @Date: 2021/12/6 15:59
 * @Version: 1.0
 * @Description: 算成绩
 */
public class ScoreDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = {"语文","数学","外语","物理","化学","生物"};
        System.out.println("请输入共有多少年的成绩");
        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][names.length];
        for (int i = 0; i < yearCount; i++){
            for (int j = 0; j < names.length; j++) {
                scores[i][j] = 80 + Math.random()*20;
            }
        }

        boolean cont = true;
        while(cont){
            System.out.println("请选择要进行的操作");
            System.out.println("1.求某年最好成绩\n" +
                    "2.求某年的平均成绩\n" +
                    "3.求所有年份最好成绩\n" +
                    "4.求某门课历年最好成绩");
            int oprtId = scanner.nextInt();
            int year = 0;
            switch (oprtId){
                case  1:
                    //求某年最好成绩
                    System.out.println("请输入要计算第几年");
                    year = scanner.nextInt();
                    double max = 0;
                    for (int i = 0; i <scores[year].length;i++){
                        if(max < scores[year][i]){
                            max = scores[year][i];
                        }
                    }
                    System.out.println("第"+year+"年最好成绩是："+max);
                    break;
                case 2:
                    //求某年的平均成绩
                    System.out.println("请输入要计算第几年");
                    year = scanner.nextInt();
                    double avt = 0;
                    for (int i = 0; i <scores[year].length;i++){
                        avt +=  scores[year][i];
                    }
                    avt = avt/names.length;
                    System.out.println("第"+year+"年最好成绩是："+avt);
                    break;
                case 3:
                    // 求所有年份最好成绩
                    double bigMax = 0;
                    for (int i = 0; i <scores.length;i++){
                        for (int j = 0; j < scores[i].length; j++) {
                            if(bigMax < scores[i][j]){
                                bigMax = scores[i][j];
                            }
                        }
                     }
                    System.out.println("所有年最好成绩是："+bigMax);
                    break;
                case 4:
                    //求某门课历年最好成绩
                    System.out.println("请选择科目语文,数学,外语,物理,化学,生物");
                    int kemu = scanner.nextInt();
                    double better = 0;
                    for (int i = 0; i <scores.length;i++){
                        if(better < scores[i][kemu]){
                            better = scores[i][kemu];
                        }
                    }
                    System.out.println(names[kemu-1]+"，历年最好成绩是："+better);
                    break;
                default:
                    break;

            }

        }
    }
}
