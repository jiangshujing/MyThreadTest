package com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class ThreadA extends Thread {

    private OneToOneConditionService service;

    public ThreadA(OneToOneConditionService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            service.set();//执行 set方法
        }


    }
}
