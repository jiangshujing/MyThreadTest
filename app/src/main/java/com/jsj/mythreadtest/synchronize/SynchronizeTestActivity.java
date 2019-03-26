package com.jsj.mythreadtest.synchronize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jsj.mythreadtest.R;
import com.jsj.mythreadtest.synchronize.innerClass.OutClass;

/**
 * Created by jiangshujing on 2018/6/12.
 */

public class SynchronizeTestActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OutClass.Inner inner = new OutClass.Inner();
        final OutClass.InnerClass2 innerClass2 = new OutClass.InnerClass2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1(innerClass2);
            }
        },"A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        },"B");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                innerClass2.method1();
            }
        },"C");

        t1.start();
//        t2.start();
        t3.start();




//        M m = new M("lock");
//        Thread1 thread1 = new Thread1(m);
//        Thread2 thread2 = new Thread2(m);
//
//        thread1.start();
//        thread2.start();
    }
}
