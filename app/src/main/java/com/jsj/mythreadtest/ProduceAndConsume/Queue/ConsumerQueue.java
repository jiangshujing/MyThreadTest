package com.jsj.mythreadtest.ProduceAndConsume.Queue;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class ConsumerQueue implements Runnable {

    private BlockingQueue proQueue;

    public ConsumerQueue(BlockingQueue proQueue) {
        this.proQueue = proQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {

                Log.d("ConsumerQueue", "消费者消费的苹果编号为 : " + proQueue.take());//检索并移除此队列的头部，如果此队列不存在任何元素，则一直等待。
                Thread.sleep(3000);  //在这里sleep是为了看的更加清楚些
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
