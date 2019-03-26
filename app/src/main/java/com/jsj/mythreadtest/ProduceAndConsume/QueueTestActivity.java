package com.jsj.mythreadtest.ProduceAndConsume;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne.OneToOneConditionService;
import com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne.ThreadA;
import com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne.ThreadB;
import com.jsj.mythreadtest.ProduceAndConsume.Queue.ConsumerQueue;
import com.jsj.mythreadtest.ProduceAndConsume.Queue.ConsumerQueueSingle;
import com.jsj.mythreadtest.ProduceAndConsume.Queue.ProducerQueue;
import com.jsj.mythreadtest.ProduceAndConsume.Queue.ProducerQueueSingle;
import com.jsj.mythreadtest.ProduceAndConsume.Queue.QueueServer;
import com.jsj.mythreadtest.ProduceAndConsume.wait_notify.Consumer;
import com.jsj.mythreadtest.ProduceAndConsume.wait_notify.Producer;
import com.jsj.mythreadtest.ProduceAndConsume.wait_notify.PublicBoxServer;
import com.jsj.mythreadtest.R;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jiangshujing on 2018/6/11.
 * 生产者-消费者模式，三种方法实现
 */

public class QueueTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //方法一： wait notify
//        method1();

        //方法二：lock condition await signalAll
//        method2();

        //方法三：阻塞队列
        method3();

    }


    private void method1() {
        // 生产者 --- 消费者 ，一对一 ,生产一个消费一个
        Log.e("QueueTestActivity", "方法一");
        PublicBoxServer server = new PublicBoxServer();
        Producer pro = new Producer(server);
        Consumer con = new Consumer(server);

        Thread thread1 = new Thread(pro);
        Thread thread2 = new Thread(con);
        thread1.start();
        thread2.start();
    }


    private void method2() {
        Log.e("QueueTestActivity", "方法二");
        // 生产者 --- 消费者 ，一对一
        OneToOneConditionService service = new OneToOneConditionService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);

        threadA.start();
        threadB.start();
    }


    private void method3() {
        Log.e("QueueTestActivity", "方法三");
        BlockingQueue publicBoxQueue = new LinkedBlockingQueue(5);   //定义了一个大小为5的盒子
        Thread pro = new Thread(new ProducerQueue(publicBoxQueue));
        Thread con = new Thread(new ConsumerQueue(publicBoxQueue));
        pro.start();
        con.start();

// 一对一
//        QueueServer queueServer = new QueueServer();
//
//        Thread pro = new Thread(new ProducerQueueSingle(queueServer));
//        Thread con = new Thread(new ConsumerQueueSingle(queueServer));
//
//        pro.start();
//        con.start();
    }
}
