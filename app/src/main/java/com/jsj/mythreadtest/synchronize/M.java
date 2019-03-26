package com.jsj.mythreadtest.synchronize;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/6/8.
 */

public class M {

    public String value = "";
    private String lock;

    public M(String lock) {
        this.lock = lock;
    }

    public void get() {
        synchronized (lock) {
            try {
                if (value.equals("")) {
                    lock.wait();//无数据先等待，有数据了再取
                }

                Log.d("M", "消费");
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void set() {

        try {
            synchronized (lock) {
                if (!value.equals("")) {
                    lock.wait();//有数据等待，无数据了再生产
                }

                Log.e("P", "生产");
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
