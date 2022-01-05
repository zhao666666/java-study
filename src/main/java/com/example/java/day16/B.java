package com.example.java.day16;

/**
 * @Author: zhaojie
 * @Date: 2022/1/5 14:11
 * @Version: 1.0
 * @Description:
 */
public class B extends A{
    ReaderB<? extends ReaderA> readerB;
    WriterB<? extends WriterB> writerB;

    public B(ReaderB r, WriterB w) {
        this.readerB = r;
        this.writerB = w;
    }
}
