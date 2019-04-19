package com.jsj.mythreadtest.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SingletonThreadTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread[] ts = new Thread[20];//同时开20个线程
        for (int i = 0; i < ts.length; i++) {
            NameThread m = new NameThread("thread:" + i);
            ts[i] = new Thread(m);
        }

        for (int i = 0; i < ts.length; i++) {
            ts[i].start();
        }
    }

    public class NameThread implements Runnable {

        String name;

        public NameThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            MySingleton.getInstance().printName(name);
        }

    }

}
