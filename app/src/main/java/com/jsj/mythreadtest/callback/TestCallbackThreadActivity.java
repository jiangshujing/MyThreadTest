package com.jsj.mythreadtest.callback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.jsj.mythreadtest.R;

public class TestCallbackThreadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TestCallbackThread", "onClick");
//                UpdaterNew.getInstance().addUpdaterRequestBeforeListener(new OnUpdaterRequestBeforeListener() {
//                    @Override
//                    public void updaterRequestBefore() {
//                        Log.e("TestCallbackThread", "updaterRequestBefore");
//                    }
//                });
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        UpdaterNew.getInstance().init(TestCallbackThreadActivity.this, 1, "2");
                        Updater.init(TestCallbackThreadActivity.this, 1, "2");
                    }
                }).start();

                Updater.addUpdaterRequestBeforeListener(new OnUpdaterRequestBeforeListener() {
                    @Override
                    public void updaterRequestBefore() {
                        Log.e("TestCallbackThread", "updaterRequestBefore");
                    }
                });

            }
        });

    }
}
