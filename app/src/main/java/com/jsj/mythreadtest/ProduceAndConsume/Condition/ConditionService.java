package com.jsj.mythreadtest.ProduceAndConsume.Condition;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiangshujing on 2018/3/29.
 */

public class ConditionService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();//获取condition对象

    /**
     * 等待
     */
    public void await(){
        try {
            lock.lock();
            Log.d("ConditionService","await 时间为"+ System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 通知
     */
    public void singnal(){
        try {
            lock.lock();
            Log.d("ConditionService","singnal 时间为"+System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }

    }
}
