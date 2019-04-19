package com.jsj.mythreadtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorTest extends AppCompatActivity {

    protected ConcurrentHashMap<String, String> mParamsMap = new ConcurrentHashMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 1秒打印一次 当前线程名
//        service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
        service.schedule(runnable, 0, TimeUnit.SECONDS);
        // 主线程等待10秒
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        for (int i = 0; i < 10; i++) {
            Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put("1", i + "");
            setParamsMap(paramsMap);
        }


        Log.e("当前线程的名字", Thread.currentThread().getName());
        get();
//        Log.e("onCreate", "主线程退出了");
    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.e("当前线程的名字", Thread.currentThread().getName());
            Map<String, String> paramsMap = new HashMap<>();
            for (int i = 10; i < 20; i++) {
                paramsMap.put("1", i + "");
                setParamsMap(paramsMap);
            }
            get();
        }
    };

    public void testThreadFactory() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    }

    public synchronized void setParamsMap(Map<String, String> paramsMap) {
//        this.mParamsMap = paramsMap;
        this.mParamsMap.clear();
        this.mParamsMap.putAll(paramsMap);

        if (paramsMap != null && paramsMap.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<Map.Entry<String, String>> iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();

                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    stringBuilder.append(key).append(":").append(value)
                            .append(",");
                }
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - ",".length());
//            Log.e("结果", stringBuilder.toString());
        }
    }


    public synchronized void get() {
        if (mParamsMap != null && mParamsMap.size() > 0) {
            Iterator<Map.Entry<String, String>> iterator = mParamsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();

                Log.e("结果 key =", key + "->value=" + value);
            }

        }
    }

}
