package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 17:38
 * @Version: 1.0
 * @Description:
 */
public class DataHolder {
    private long number = 0;
    private static long staticNumber = 0;

    // 多个实例，可以进入
    public void change(long delta) {
        synchronized(DataHolder.class){
            number+=delta;
        }

    }

    // 类锁（.class）
    public synchronized static void changeStatic(long delta) {
        staticNumber+=delta;
    }

    public void print() {
        System.out.println("number:"+number);
    }

    public void printStatic() {
        System.out.println("staticNumber:"+staticNumber);
    }
}
