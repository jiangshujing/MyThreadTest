package com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class ThreadB extends Thread {

    private OneToOneConditionService service;

    public ThreadB(OneToOneConditionService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            service.get();//执行 get方法
        }
    }
}
