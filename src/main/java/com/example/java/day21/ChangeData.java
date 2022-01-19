package com.example.java.day21;

/**
 * @Author: zhaojie
 * @Date: 2022/1/12 17:38
 * @Version: 1.0
 * @Description:
 */
public class ChangeData implements Runnable{
    private long delta;
    private long loopCount;
    private DataHolder dataHolder;

    public ChangeData(long delta, long loopCount, DataHolder dataHolder) {
        this.delta = delta;
        this.loopCount = loopCount;
        this.dataHolder = dataHolder;
    }


    @Override
    public void run() {
        for (long i = 0; i < loopCount; i++) {
            dataHolder.change(delta);
            // DataHolder.changeStatic(delta);
        }
        dataHolder.print();
        dataHolder.printStatic();
    }
}
