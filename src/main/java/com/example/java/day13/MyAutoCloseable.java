package com.example.java.day13;

import java.io.IOException;

/**
 * @Author: zhaojie
 * @Date: 2021/12/27 17:32
 * @Version: 1.0
 * @Description:
 */
public class MyAutoCloseable implements AutoCloseable {
    private String resName;
    private int counter;

    public MyAutoCloseable(String resName) {
        this.resName = resName;
    }

    public MyAutoCloseable(String resName, int counter) {
        this.resName = resName;
        this.counter = counter;
    }

    public String read() throws IOException {
        counter++;
        if(Math.random() > 0.1){
            return resName +"：" + counter;
        }else{
            throw new IOException("resource不存在");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("资源释放"+resName);
    }
}
