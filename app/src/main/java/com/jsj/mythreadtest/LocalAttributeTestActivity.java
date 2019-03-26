package com.jsj.mythreadtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by jiangshujing on 2018/6/27.
 * 验证局部变量不存在线程安全问题
 * 由于局部变量对于每一个线程来说都有自己的拷贝，所以各个线程之间不再共享同一个变量，
 * 输出结果为100个数字，实际上是两组，每组都是0到49的50个数字，并且两组数字之间随意地穿插在一起
 */

public class LocalAttributeTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelloThread r = new HelloThread();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }

    class HelloThread implements Runnable {
        // int i;
        // 若i是成员变量，则HelloThread的对象r只包含这一个i，两个Thread对象因为由r构造，所以共享了同一个i
        // 打印结果是0到49的数字
        @Override
        public void run() {
            int i = 0;//局部变量变量
            // 每一个线程都会拥有自己的一份局部变量的拷贝
            // 线程之间互不影响
            // 所以会打印100个数字，0到49每个数字都是两遍
            while (true) {
                Log.e("Test", "Hello number: " + i++);

                try {
                    Thread.sleep((long) Math.random() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (50 == i) {
                    break;
                }
            }
        }
    }
}

