package com.example.java.day23;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 14:01
 * @Version: 1.0
 * @Description:
 */
public class Task1 implements Runnable{
    private AppResources appResources;

    public Task1(AppResources appResources){this.appResources = appResources;}

    @Override
    public void run() {
        synchronized(appResources.getResourceInput()){
            System.out.println("Task1得到了Input资源");
            System.out.println("Task1开始工作。。。");
            try{
                Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("Task1尝试去获取Printer资源");
            synchronized(appResources.getResourcePrinter()){
                System.out.println("Task1得到了Printer资源");
                System.out.println("Task1继续工作。。。");
                try{
                    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
