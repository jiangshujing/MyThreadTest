package com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne;

import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiangshujing on 2018/4/3.
 * 使用Lock 和 Condition解决生产者消费者问题
 */

public class OneToOneConditionService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //仓库中是否有值
    private boolean hasValue = false;
    private String TAG = this.getClass().getSimpleName();

    public void set() {
        try {
            lock.lock();//获取锁
            while (hasValue) {
                condition.await();//等待
            }
            Log.d(TAG, "生产");
            hasValue = true;
            condition.signal();//通知

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }
    }

    public void get() {
        try {
            lock.lock();//获取锁
            while (!hasValue) {
                condition.await();//等待
            }
            Log.d(TAG, "消费");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
