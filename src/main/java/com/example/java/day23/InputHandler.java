package com.example.java.day23;


/**
 * @Author: zhaojie
 * @Date: 2022/1/18 14:57
 * @Version: 1.0
 * @Description:
 */
public class InputHandler {
    public String getInput(){
        return productString();
    }

    private String productString() {
        PerformanceTracker.startPhase();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int rand = (int)((Math.random() * 1000)%26);
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        PerformanceTracker.endPhase("InputGen");
        return ret.toString();
    }
}
