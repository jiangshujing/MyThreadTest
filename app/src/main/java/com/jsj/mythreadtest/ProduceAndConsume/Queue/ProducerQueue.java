package com.jsj.mythreadtest.ProduceAndConsume.Queue;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class ProducerQueue implements Runnable {

    private BlockingQueue proQueue;

    public ProducerQueue(BlockingQueue proQueue) {
        this.proQueue = proQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Log.d("ProducerQueue","生产者生产的苹果编号为 : " +i);
                proQueue.put(i);//将指定元素添加到此队列中，如果没有可用空间，将一直等待（如果有必要）。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
