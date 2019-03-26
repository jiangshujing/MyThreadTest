package com.jsj.mythreadtest.ProduceAndConsume.wait_notify;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/4/3.
 * 公共的
 */

public class PublicBoxServer {

    private static final int SIZE = 10;
    private int apple = 0;

    /**
     * 生产苹果
     */
    public synchronized void produce() {

        while (apple == SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        apple++;
        Log.d("PublicBoxServer", "生产苹果成功" );
        notifyAll();
    }


    /**
     * 消费者
     */
    public synchronized void consume() {
        while (apple == 0) {
            try {
                wait();//等待，当有苹果了在吃
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        apple--;
        Log.d("PublicBoxServer", "消费苹果成功");
        notifyAll();
    }
}
