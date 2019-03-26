package com.jsj.mythreadtest.ProduceAndConsume.Condition;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiangshujing on 2018/3/29.
 */

public class MoreConditionService {

    private Lock lock = new ReentrantLock();

    public Condition conditionA = lock.newCondition();//控制线程A的Condition
    public Condition conditionB = lock.newCondition();//控制线程B的Condition


    /**
     * A 等待
     */
    public void awaitA(){

        try {
            lock.lock();
            Log.d("MoreConditionService","begin awaitA 时间为"+ System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
            conditionA.await();
            Log.d("MoreConditionService","end awaitA 时间为"+ System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }


    /**
     * B 等待
     */
    public void awaitB(){

        try {
            lock.lock();
            Log.d("MoreConditionService","begin awaitB 时间为"+ System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
            conditionB.await();
            Log.d("MoreConditionService","end awaitB 时间为"+ System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    /**
     * 通知 A
     */
    public void signalAll_A(){

        try {
            lock.lock();
            Log.d("MoreConditionService"," signalAll_A 时间为"+ System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 通知 B
     */
    public void signalAll_B(){

        try {
            lock.lock();
            Log.d("MoreConditionService"," signalAll_B 时间为"+ System.currentTimeMillis()+"ThreadName"+Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }

    }
}
