package com.jsj.mythreadtest.ProduceAndConsume.Queue;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class ConsumerQueueSingle implements Runnable {

    private QueueServer server;

    public ConsumerQueueSingle(QueueServer server) {
        this.server = server;
    }

    @Override
    public void run() {
//        server.consume();

        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server.consume();
            Log.d("QueueServer", "消费苹果成功");
        }
    }
}
