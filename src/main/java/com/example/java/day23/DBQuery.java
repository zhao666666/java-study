package com.example.java.day23;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 15:02
 * @Version: 1.0
 * @Description:
 */
public class DBQuery {
    public void query(){
        PerformanceTracker.startPhase();

        try {
            Thread.sleep((int)Math.random()* TimeUnit.SECONDS.toMillis(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceTracker.endPhase("DBQuery");
    }
}
