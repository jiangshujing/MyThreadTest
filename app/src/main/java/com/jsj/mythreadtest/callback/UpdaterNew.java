package com.jsj.mythreadtest.callback;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;


public class UpdaterNew {
    private Checker checker;
//    private static IntentFilter filter;
//    private static final String android_net_wifi_STATE_CHANGE = "android.net.wifi.STATE_CHANGE";
//    private static final String android_net_wifi_WIFI_STATE_CHANGED = "android.net.wifi.WIFI_STATE_CHANGED";

    private volatile static UpdaterNew instance;


    private UpdaterNew() {
    }

    public static UpdaterNew getInstance() {
        //一重锁：先判断实例是否存在,不存在进入同步代码块 ,作用：为了不必要的同步
        if (instance == null) {
            synchronized (UpdaterNew.class) {
                //二重锁：再次判断实例是否存在，如果不存在，创建实例 ，作用：为了在实例不存在的情况下创建实例
                if (instance == null) {
                    instance = new UpdaterNew();
                }
            }
        }

        return instance;
    }


    public void init(Context context, int networkType, String sdkVersion) {
        if (context == null) {
            throw new RuntimeException("Context is null, please set the context.");
        }

        Log.i("Updater", "Update start init~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Log.i("Updater", "networkType ->" + networkType);
        Log.i("Updater", "sdkVersion ->" + sdkVersion);

        if (checker == null) {
            checker = new Checker();
        }

        checker.initCheck(true);

//        if (filter == null) {
//            filter = new IntentFilter();
//
//            filter.addAction(Intent.ACTION_SCREEN_ON);
//            filter.addAction(Intent.ACTION_BATTERY_OKAY);
//            filter.addAction(Intent.ACTION_POWER_CONNECTED);
//
//            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//            filter.addAction(android_net_wifi_WIFI_STATE_CHANGED);
//            filter.addAction(android_net_wifi_STATE_CHANGE);
//
//            sContext.registerReceiver(checker, filter);
//        }
    }

    public void addUpdaterRequestBeforeListener(OnUpdaterRequestBeforeListener listener) {
        if (checker == null) {
            return;
        }

        checker.putUpdaterRequestBeforeListener(listener);
    }


    public class Checker extends BroadcastReceiver {
        private UpdateContext updateContext;

        public Checker() {
            updateContext = new UpdateContext();
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            initCheck(true);
        }

        void putUpdaterRequestBeforeListener(OnUpdaterRequestBeforeListener listener) {
            updateContext.addUpdaterRequestBeforeListener(listener);
        }

        void doCheck() {
            UpdateCenter.update(updateContext);
        }

        void initCheck(boolean isDelayTime) {


            Runnable runner = new Runnable() {
                PowerManager.WakeLock mWakeLock;

                @Override
                public void run() {
                    try {
                        Log.i("Updater", "update thread start running");
                        doCheck();
                        Log.i("Updater", "Update finish~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    } catch (Exception e) {
                        Log.e("Updater", "do check error", e);
                    }
                }
            };

            new Thread(runner).start();
        }
    }
}
