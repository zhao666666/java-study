package com.example.java.day21;

import lombok.SneakyThrows;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 16:04
 * @Version: 1.0
 * @Description:
 */
public class MyThread {
    public static final String TEXT = "11112222111111111111111111111111111111";
    public static volatile int a = -1;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 1; i <=1;i++){
            Thread thread = new Thread(new PriintStoryRunnable(TEXT, 5000 * i), "我的线程-" + i);
            //thread.setDaemon(true);
            // 设置线程的优先级
            //thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            // stop方法可以让线程结束，但是会造成程序状态的错误，比如锁没有释放。
            // thread.stop();
            threads.add(thread);
        }
        // 时间转换 TimeUnit.SECONDS.toMillis(5)
        System.out.println("开始interrupt线程");
        threads.forEach(Thread::interrupt);

        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("启动线程结束，名字叫做"+Thread.currentThread().getName());
    }

    private static class PriintStoryRunnable implements Runnable {

        private String text;
        private int interval;
        public PriintStoryRunnable(String text, int i) {
            this.text = text;
            this.interval = i;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("线程的名称叫:"+Thread.currentThread().getName());
            a=interval;
            printSlowly(text,interval);
            // 循环线程，中断线程
            long statrt = System.currentTimeMillis();
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            System.out.println("状态变化为"+isInterrupted);
            int count = 0;
            while(true){
                count++;
                if(isInterrupted != Thread.currentThread().isInterrupted()){
                    isInterrupted = Thread.currentThread().isInterrupted();
                    System.out.println("状态变化为"+isInterrupted);
                }else{
                    System.out.println(count);
                }
                if(System.currentTimeMillis() - statrt > interval){
                    break;
                }
            }
            System.out.println("执行结束");
        }
    }

    private static void printSlowly(String a, int i) throws InterruptedException {
        for(char c:a.toCharArray()){
            Thread.sleep(i);
            System.out.print(c);
        }
        System.out.println();
    }
}
