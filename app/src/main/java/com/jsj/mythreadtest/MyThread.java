package com.jsj.mythreadtest;

/**
 * Created by jiangshujing on 2018/3/29.
 */

public class MyThread extends Thread {

    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
