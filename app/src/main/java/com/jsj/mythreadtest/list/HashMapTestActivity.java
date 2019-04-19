package com.jsj.mythreadtest.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTestActivity extends AppCompatActivity {

    private HashMap map = new HashMap();
//    private Map map = Collections.synchronizedMap(new HashMap());
//    private ConcurrentHashMap map = new ConcurrentHashMap();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Runnable aaa = new Runnable1();
        for (int i = 0; i < 10; i++) {
            new Thread(aaa).start();
        }
    }


    class Runnable1 implements Runnable {

        @Override
        public void run() {
//            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    map.put(Thread.currentThread().getName() + i, i);
                }
                //如果是线程安全,那么HashMap的大小,最后能够达到1W.
                System.out.println(Thread.currentThread().getName() + ": " + map.size());
            }
//        }
    }
}
