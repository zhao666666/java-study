package com.example.java.day23;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 15:17
 * @Version: 1.0
 * @Description:
 */
public class UseThreadLocal {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread workingThread = new Thread(()->{
                System.out.println("开始处理");
                PerformanceTracker.reset();

                InputHandler input = new InputHandler();
                String content = input.getInput();

                DBQuery query = new DBQuery();
                query.query();

                ContentProcess contentProcess = new ContentProcess();
                contentProcess.process(content);

                PerformanceTracker.finish();
            },"Worker"+i);
            workingThread.start();
        }
    }
}
