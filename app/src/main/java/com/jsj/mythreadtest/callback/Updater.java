package com.jsj.mythreadtest.callback;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import android.util.Log;


public class Updater {
    public static Checker checker;
    private static Context sContext;
    private static IntentFilter filter;
    private static final String android_net_wifi_STATE_CHANGE = "android.net.wifi.STATE_CHANGE";
    private static final String android_net_wifi_WIFI_STATE_CHANGED = "android.net.wifi.WIFI_STATE_CHANGED";

    public static void addUpdaterRequestBeforeListener(OnUpdaterRequestBeforeListener listener) {
        if (checker == null) {
            return;
        }

        checker.putUpdaterRequestBeforeListener(listener);
    }


    public static void init(Context context, int networkType, String sdkVersion) {
        if (context == null) {
            throw new RuntimeException("Context is null, please set the context.");
        }

        Log.i("Updater", "Update start init~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Log.i("Updater", "networkType ->" + networkType);
        Log.i("Updater", "sdkVersion ->" + sdkVersion);

        Context appContext = context.getApplicationContext();
        if (appContext == null) {
            appContext = context;
        }

        sContext = appContext;

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


    public static class Checker extends BroadcastReceiver {
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
//            UpdateCenter.update(updateContext);
            new UpdateCenter(updateContext).update(updateContext);
        }

        void initCheck(boolean isDelayTime) {


            Runnable runner = new Runnable() {
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
