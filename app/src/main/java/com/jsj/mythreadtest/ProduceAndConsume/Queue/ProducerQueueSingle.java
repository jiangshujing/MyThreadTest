package com.jsj.mythreadtest.ProduceAndConsume.Queue;

import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class ProducerQueueSingle implements Runnable {

    private QueueServer server;

    public ProducerQueueSingle(QueueServer server) {
        this.server = server;
    }

    @Override
    public void run() {
//        server.produce();

        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server.produce();
            Log.d("QueueServer", "生产苹果成功");
        }
    }


}
