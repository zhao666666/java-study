package com.example.java.day05;

import java.util.Scanner;

/**
 * @Author: zhaojie
 * @Date: 2021/12/7 15:39
 * @Version: 1.0
 * @Description:
 */
public class RunLittleSupperMarket {
    public static void main(String[] args) {
        LittleSupperMarket littleSupperMarket = new LittleSupperMarket();
        littleSupperMarket.address = "天府大道";
        littleSupperMarket.superMarketName = "超市";
        littleSupperMarket.parkingCount = 200;
        littleSupperMarket.merchandises = new Merchandise[200];
        littleSupperMarket.merchandiseSold = new int[littleSupperMarket.merchandises.length];

        Merchandise[] all = littleSupperMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (Math.random() + 1) + 200;
            all[i] = m;
        }

        System.out.println("超市开门");
        boolean open = true;
        Scanner scanner = new Scanner(System.in);
        while (open) {
            System.out.println("店名：" + littleSupperMarket.superMarketName);
            System.out.println("地址：" + littleSupperMarket.address);
            System.out.println("停车位：" + littleSupperMarket.parkingCount);
            System.out.println("商品个数：" + littleSupperMarket.merchandises.length);
            System.out.println("营业额：" + littleSupperMarket.incomingSum);

            Customer customer = new Customer();
            customer.name = "顾客编号" + (int) Math.random() * 10000;
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = (Math.random()) > 0.5;
            if (customer.isDrivingCar) {
                if (littleSupperMarket.parkingCount > 0) {
                    System.out.println("欢迎" + customer.name + "来到本店，您的车位编号是" + littleSupperMarket.parkingCount);
                    littleSupperMarket.parkingCount--;
                } else {
                    System.out.println("欢迎下次再来");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "来到本店");
            }
            double totalCost = 0;
            while (true) {
                System.out.println("本店提供" + all.length + "种类，请输入商品编号");
                int index = scanner.nextInt();
                if (index < 0 || index >= all.length) {
                    break;
                }
                Merchandise m = all[index];
                System.out.println("您选购的商品名称是" + m.name + "单价是" + m.soldPrice + "您需要购买个数？");
                int numToBuy = scanner.nextInt();
                if (numToBuy < 0 || numToBuy >= 200) {
                    System.out.println("个数不对，请继续选购");
                    continue;
                }

                if (numToBuy * m.soldPrice > customer.money) {
                    System.out.println("对不起，你带的钱不够");
                    continue;
                }

                totalCost += numToBuy * m.soldPrice;

                m.count -= numToBuy;
                littleSupperMarket.merchandiseSold[index] += numToBuy;

            }

            customer.money -= totalCost;
            if (customer.isDrivingCar) {
                littleSupperMarket.parkingCount++;
            }
            System.out.println("顾客" + customer.name + "消费了" + totalCost);
            littleSupperMarket.incomingSum += totalCost;

            System.out.println("是否继续营业");
            open = scanner.hasNextBoolean();
        }

        System.out.println("关门了");
        System.out.println("今日总的营业额" + littleSupperMarket.incomingSum);

        for (int i = 0; i < littleSupperMarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = littleSupperMarket.merchandiseSold[i];
            if (numSold > 0) {
                double incoming = m.soldPrice * numSold;
                double netIncoming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "今日卖出销售额" + incoming + "纯利润是" + netIncoming);
            }
        }

    }
}
