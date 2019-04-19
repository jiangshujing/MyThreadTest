package com.jsj.mythreadtest.method;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jsj.mythreadtest.R;

public class TestThreadMethodActivity1 extends AppCompatActivity {

    private AThread thread_a;
    private BThread thread_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread_a = new AThread("thread_a");
        thread_b = new BThread("thread_b");
        thread_a.add(thread_b);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread_a.start();
                thread_b.start();
            }
        });
    }

    private void B() {
        Log.d("Thread", Thread.currentThread().getName() + "........执行了B方法");

    }

    private void init() {
        Log.d("Thread", Thread.currentThread().getName() + "........执行了init方法");
    }

    /**
     * 订阅者
     */
    public interface Observer {
        void doB();
    }

    /**
     * 被订阅者 放init的方法
     */
    public interface Observable {
        void initIsDown();

        void add(Observer observer);
    }

    /**
     * init 的线程
     */
    private class AThread extends Thread implements Observable {
        public AThread(String name) {
            super(name);
        }

        Observer observer;

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                init();
                initIsDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        @Override
        public void initIsDown() {
            if (observer != null) {
                observer.doB();
            }
        }

        @Override
        public void add(Observer observer) {
            this.observer = observer;
        }
    }

    /**
     * 其余订阅init的线程
     */
    private class BThread extends Thread implements Observer {

        public BThread(String name) {
            super(name);
        }

        @Override
        public void run() {
//            for (int i = 0; i < 50; i++) {
//                try {
//                    Log.d("Thread", Thread.currentThread().getName() + ".......执行了其他方法");
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        @Override
        public void doB() {
            B();
        }
    }


}
