package com.example.java.day24;

import java.util.concurrent.*;

/**
 * @Author: zhaojie
 * @Date: 2022/1/20 10:48
 * @Version: 1.0
 * @Description:
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                3,                          // 核心线程数
                5,                      // 线程池最大数
                0L,                        // 空闲线程最大存活时间
                TimeUnit.MILLISECONDS,                  // 时间单位
                new LinkedBlockingQueue<Runnable> (), // 线程池使用的缓存队列
                Executors.defaultThreadFactory(),      // 线程池创建线程使用的工厂
                new ThreadPoolExecutor.AbortPolicy()    //拒绝策略
        );
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName());
        });
        // 方法执行，返回一个，标识任务等待完成的future
        Future<String> future = executorService.submit(() -> "这是返回值");


        executorService.execute(() -> System.out.println(111));

        executorService.shutdown();

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
