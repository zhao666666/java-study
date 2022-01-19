package com.example.java.day22;

import java.util.Queue;

/**
 * @Author: zhaojie
 * @Date: 2022/1/13 15:40
 * @Version: 1.0
 * @Description:
 */
public class Producer<T> {
    private Queue<T> tasks;

    private int maxTaskCount;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    public void product(T task) throws Exception{
        synchronized(tasks){
            // 不能用if 虚假唤醒
            while(tasks.size() >= maxTaskCount)
            {
                System.out.println("生产者线程进行等待："+Thread.currentThread().getName());
                tasks.wait();
            }
            tasks.add(task);
            tasks.notifyAll();
        }
    }
}
