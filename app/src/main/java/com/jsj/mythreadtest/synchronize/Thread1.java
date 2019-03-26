package com.jsj.mythreadtest.synchronize;

/**
 * Created by jiangshujing on 2018/6/8.
 * 消费者
 */

public class Thread1 extends Thread {

    private M manager;

    public  Thread1(M manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 5; i++) {
            manager.set();
        }

    }
}
