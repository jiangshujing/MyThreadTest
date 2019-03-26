package com.jsj.mythreadtest.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jsj.mythreadtest.R;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by jiangshujing on 2018/6/13.
 */

public class ListConcurrentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Collection<String> num = new CopyOnWriteArrayList<String>();
        num.add("One");
        num.add("Two");
        num.add("Three");


        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000);//没挺一秒后向集合中添加个item
                    num.add("one " + System.currentTimeMillis());

//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (String str : num) {
                    Log.e("ListConcurrentActivity", "name === " + str);
                    if (str.equals("Three")) {
                        num.remove(str);
                    }
                }

                for (String str : num) {
                    Log.e("ListConcurrentActivity", "name === " + str);
                }
            }
        }).start();

    }
}
