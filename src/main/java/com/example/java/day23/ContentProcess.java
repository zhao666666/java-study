package com.example.java.day23;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 15:14
 * @Version: 1.0
 * @Description:
 */
public class ContentProcess {

    public void process(String content){
        PerformanceTracker.startPhase();
        int ms = content.chars().reduce(Integer::sum).orElse(0);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceTracker.endPhase("ProcessContent");
    }
}
