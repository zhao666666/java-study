package com.example.java.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 10:16
 * @Version: 1.0
 * @Description:
 */
public class ThreadJoin {
    private static final List<String> CONTENTS = new ArrayList<String>();

    private static long WORKING_DURATION = 0;

    public static void main(String[] args) throws InterruptedException {
        long mainStart = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":开始抓取网页内容");
                long start = System.currentTimeMillis();
                String content = getContentFromWeb();
                long threadWordkTime = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + ":抓取网页内容结束");
                synchronized(CONTENTS){
                    CONTENTS.add(content);
                    // 获取线程工作时间
                    WORKING_DURATION += threadWordkTime;
                }
            },"线程"+i);
            thread.start();
            threads.add(thread);
        }
        Thread.sleep(1);

        System.out.println("主线程开始join");
        for (Thread thread : threads) {
            try{
                String name = thread.getName();
                System.out.println("主线程开始join"+name);
                thread.join();
                System.out.println("主线程join"+name+"结束");
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("主线程join结束，获取的内容为：");
            CONTENTS.forEach(s->{
                System.out.println(s.length()+":"+s);
            });

            // 主线程工作时间
            long mainWork = System.currentTimeMillis() - mainStart;
            System.out.println(WORKING_DURATION);
            System.out.println(mainWork);
        }
    }

    private static String getContentFromWeb() {
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
