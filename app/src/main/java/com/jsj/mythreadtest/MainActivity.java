package com.jsj.mythreadtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne.OneToOneConditionService;
import com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne.ThreadA;
import com.jsj.mythreadtest.ProduceAndConsume.Condition.OneToOne.ThreadB;
//import com.jsj.mythreadtest.MyHandler.Handler;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyService service = new MyService();
//        MyThread thread1 = new MyThread(service);
//        MyThread thread2 = new MyThread(service);
//        MyThread thread3 = new MyThread(service);
//        MyThread thread4 = new MyThread(service);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();


//        try {
//            ConditionService service1 = new ConditionService();
//            ThreadA threadA = new ThreadA(service1);//run方法中执行了await() 方法
//            threadA.start();
//            Thread.sleep(3000);
//            service1.singnal();//执行唤醒方法
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//
//        try {
//            MoreConditionService service = new MoreConditionService();
//            ThreadB threadB = new ThreadB(service);
//            threadB.setName("B");
//            threadB.start();//启动 B
//
//            ThreadC threadC = new ThreadC(service);
//            threadC.setName("C");
//            threadC.start();//启动 C
//
//            Thread.sleep(3000);
//
//            service.signalAll_A();//唤醒第一个线程
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        // 生产者 --- 消费者 ，一对一
        OneToOneConditionService service = new OneToOneConditionService();
        ThreadA threadA = new ThreadA(service);
        ThreadB threadB = new ThreadB(service);
        threadA.start();
        threadB.start();

//
//        PublicBoxServer server = new PublicBoxServer();
//
//        Producer pro = new Producer(server);
//        Consumer con = new Consumer(server);
//
//        Thread thread1 = new Thread(pro);
//        Thread thread2 = new Thread(con);
//
//        thread1.start();
//        thread2.start();


//        BlockingQueue publicBoxQueue= new LinkedBlockingQueue(5);   //定义了一个大小为5的盒子
//
//        Thread pro= new Thread(new ProducerQueue(publicBoxQueue));
//        Thread con= new Thread(new ConsumerQueue(publicBoxQueue));
//
//        pro.start();
//        con.start();

        //初始化 Looper
//        Looper.prepare();
//
//        final Handler mHandler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                //获得刚才发送的Message对象，然后在这里进行UI操作
//                Log.e("MainActivity", "------------> msg.what = " + msg.what);
//            }
//        };
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Message message = new Message();
//                message.what = 123;
//                mHandler.sendMessage(message);
//                Log.e("MainActivity", "mHandler");
//            }
//        }).start();
//        //消息循环
//        Looper.loop();
//
//
//        /**
//         * 调用 线程返回数据
//         * 必须使用ExecutorService的submit方法来执行，返回一个Future对象
//         * 可以使用isDone()方法检测future是否完成，完成后可以调用get()方法获得future的
//         * 值， 如果直接调用get()方法，get()方法将阻塞值线程结束
//         */
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Callable<String> callable = new RetureDataThread.MyTread();
//        Future future = executorService.submit(callable);
//        if (future.isDone()) {//判断是否完成
//            try {
//                Log.d("MainActivity", "获取工作线程完成后的数据" + future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }


    }


}
