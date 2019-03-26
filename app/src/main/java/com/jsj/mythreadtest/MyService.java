package com.jsj.mythreadtest;

import android.util.Log;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiangshujing on 2018/3/29.
 */

public class MyService {

    private Lock lock = new ReentrantLock();


    public void testMethod() {
        lock.lock();//获取锁

        for (int i = 0; i < 5; i++) {
            Log.d("MyService = ","ThreadName"+Thread.currentThread().getName()+"("+(i+1)+")");
        }

        lock.unlock();//释放锁
    }
}
