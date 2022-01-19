package com.example.java.day22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/13 9:50
 * @Version: 1.0
 * @Description:
 */
public class ProducerConsumerAppMain {
    public static final Object o = new Object();

    public static void main(String[] args)  {
        Queue<String> queue = new LinkedList<>();

        Consumer<String> consumer = new Consumer<>(queue);
        Producer<String> producer = new Producer<>(queue,1024);
        for (int i = 0; i < 100; i++) {
            Thread consumerThread = new Thread(()->{
                while (true){
                    String url = null;
                    try {
                        url = consumer.consume();
                        processURL(url);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"消费者-"+i);
            consumerThread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread producerThread = new Thread(()->{
                while (true){
                    try {
                        String url = ProduceURL();
                        producer.product(url);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            },"生产者-"+i);

            producerThread.start();
        }

    }

    private static String ProduceURL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = (int) (Math.random()*1000)%26;
            char ch = (char) (rand + 'a');
            stringBuilder.append(ch);
        }
        stringBuilder.append(".com");
        return stringBuilder.toString();
    }

    private static void processURL(String url) throws InterruptedException {
        System.out.println("开始处理"+url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("处理结束"+url);

    }
}
