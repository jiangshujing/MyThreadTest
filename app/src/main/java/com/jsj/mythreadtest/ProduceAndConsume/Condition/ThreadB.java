package com.jsj.mythreadtest.ProduceAndConsume.Condition;

/**
 * Created by jiangshujing on 2018/4/2.
 */

public class ThreadB extends Thread {

    private MoreConditionService service;

    public ThreadB(MoreConditionService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();//a等待
    }
}
