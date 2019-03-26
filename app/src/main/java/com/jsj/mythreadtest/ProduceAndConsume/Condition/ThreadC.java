package com.jsj.mythreadtest.ProduceAndConsume.Condition;

/**
 * Created by jiangshujing on 2018/4/2.
 */

public class ThreadC extends Thread {

    MoreConditionService service;

    public ThreadC(MoreConditionService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();//B 等待
    }
}
