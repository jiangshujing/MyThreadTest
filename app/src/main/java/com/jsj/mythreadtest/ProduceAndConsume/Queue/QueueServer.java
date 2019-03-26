package com.jsj.mythreadtest.ProduceAndConsume.Queue;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jiangshujing on 2018/4/3.
 * 公共的
 */

public class QueueServer {

    private static final int SIZE = 10;
    BlockingQueue<String> publicBoxQueue = new LinkedBlockingQueue<>(SIZE);   //定义了一个大小为5的盒子
//    private int apple;

    /**
     * 生产苹果
     */
    public synchronized void produce() {
        try {
            publicBoxQueue.put("111");//将指定元素添加到此队列中，如果没有可用空间，将一直等待（如果有必要）。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 消费者
     */
    public synchronized void consume() {
        try {
            publicBoxQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
