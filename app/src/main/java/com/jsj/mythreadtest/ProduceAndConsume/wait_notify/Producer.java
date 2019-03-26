package com.jsj.mythreadtest.ProduceAndConsume.wait_notify;

/**
 * Created by jiangshujing on 2018/4/3.
 * 生产者
 */

public class Producer implements Runnable {

    private PublicBoxServer server;

    public Producer(PublicBoxServer server) {
        this.server = server;
    }


    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            server.produce();
//        }

        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server.produce();
        }
    }
}
