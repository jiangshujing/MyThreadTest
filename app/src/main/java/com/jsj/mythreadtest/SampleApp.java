package com.jsj.mythreadtest;

import android.app.Application;
import android.util.Log;

import com.jsj.mythreadtest.callback.OnUpdaterRequestBeforeListener;
import com.jsj.mythreadtest.callback.Updater;



public class SampleApp extends Application {
    private static final String TAG = SampleApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
