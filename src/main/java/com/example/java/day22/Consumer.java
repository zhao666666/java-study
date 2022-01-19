package com.example.java.day22;

import java.util.List;
import java.util.Queue;

/**
 * @Author: zhaojie
 * @Date: 2022/1/13 15:39
 * @Version: 1.0
 * @Description:
 */
public class Consumer<T> {
    Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException {
        synchronized(tasks){
            while(tasks.size() == 0){
                System.out.println("消费者线程进行等待"+Thread.currentThread().getName());
                tasks.wait();
            }
            T ret = tasks.poll();
            tasks.notifyAll();
            return ret;
        }
    }
}
