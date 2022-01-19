package com.example.java.day23;

import java.util.TimerTask;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 18:17
 * @Version: 1.0
 * @Description:
 */
public class FindABCTask extends TimerTask {
    @Override
    public void run() {
        try {
            String content = getWebContext();
            if(content.contains("ABC")){
                System.out.println("Find ABC in" + content);
            }else{
                System.out.println(content);
                System.out.println("ABC not find");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getWebContext() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = (int) (Math.random()*1000)%26;
            char ch = (char) (rand + 'A');
            stringBuilder.append(ch);
        }
        stringBuilder.append(".com");
        return stringBuilder.toString();
    }
}
