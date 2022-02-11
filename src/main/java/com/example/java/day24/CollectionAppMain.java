package com.example.java.day24;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: zhaojie
 * @Date: 2022/1/19 17:49
 * @Version: 1.0
 * @Description:
 */
public class CollectionAppMain {
    public static void main(String[] args) {
        // 堵塞队列
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(128);
        // 获取队列的最前面的数据
        linkedBlockingQueue.peek();
        // 将元素放入队列，返回是否放入成功。一般再限制队列大小的情况下才会失败，毕竟到达Integer.MAX_VALUE程序可能就因为没有内存挂了
        boolean added = linkedBlockingQueue.offer("");
        System.out.println(added);

        // 队列有就拿出来
        linkedBlockingQueue.poll();
        //offer 和 poll 是一对，随缘，能放就放，不行就算了

        /**
         * put 和 take 模拟生产者，消费者模式
         */
        try {
            // 需要等待
            linkedBlockingQueue.put("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            // 一定要拿到一个
            linkedBlockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
