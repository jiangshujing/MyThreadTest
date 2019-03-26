package com.jsj.mythreadtest.synchronize;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by jiangshujing on 2018/6/8.
 * 生产者
 */

public class Thread2 extends Thread {


    private M manager;

    public Thread2(M manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
//        super.run();
        for (int i = 0; i < 5; i++) {
            manager.get();
        }

    }
}
