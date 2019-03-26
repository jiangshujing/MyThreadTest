package com.jsj.mythreadtest.ProduceAndConsume.Condition;

/**
 * Created by jiangshujing on 2018/3/29.
 */

public class ThreadA extends Thread {

    private ConditionService service;

    public ThreadA(ConditionService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
