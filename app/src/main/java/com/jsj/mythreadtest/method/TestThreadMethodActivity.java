//package com.jsj.mythreadtest.method;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//
//import com.jsj.mythreadtest.R;
//import com.jsj.mythreadtest.callback.OnUpdaterRequestBeforeListener;
//import com.jsj.mythreadtest.callback.Updater;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class TestThreadMethodActivity extends AppCompatActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("TestThreadMethod", "onClick");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        Utils.init(TestThreadMethodActivity.this, 1, "2");
//                    }
//                }).start();
//
//
//                Utils.addListener();
////                Updater.addUpdaterRequestBeforeListener(new OnUpdaterRequestBeforeListener() {
////                    @Override
////                    public void updaterRequestBefore() {
////                        Log.e("TestThreadMethod", "updaterRequestBefore");
////                    }
////                });
//            }
//        });
//
//    }
//}
