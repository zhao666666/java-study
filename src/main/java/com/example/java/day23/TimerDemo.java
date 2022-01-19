package com.example.java.day23;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 18:22
 * @Version: 1.0
 * @Description:
 */
public class TimerDemo {
    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new FindABCTask(),0, TimeUnit.SECONDS.toMillis(2));

        // 替换Timer,timer无法处理异常
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new FindABCTask(),0,3,TimeUnit.SECONDS);
    }
}
