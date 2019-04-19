//package com.jsj.mythreadtest.method;
//
//import android.content.Context;
//import android.util.Log;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//
//public class Utils {
//
//    Lock lock = new ReentrantLock();
//    Condition a = lock.newCondition();
//    Condition b = lock.newCondition();
//
//    public  void init(Context context, int networkType, String sdkVersion) {
//        if (context == null) {
//            throw new RuntimeException("Context is null, please set the context.");
//        }
//
//        lock.lock();
//        Log.i("Utils", "Update start init~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
////        Log.i("Updater", "networkType ->" + networkType);
////        Log.i("Updater", "sdkVersion ->" + sdkVersion);
////
//        try {
//            a.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            lock.unlock();//释放锁
//        }
//        b.signal();
//    }
//
//    public static void addListener() {
//        lock.lock();
//        Log.i("Utils", "set");
////        Log.i("Updater", "networkType ->" + networkType);
////        Log.i("Updater", "sdkVersion ->" + sdkVersion);
////
//        try {
//            b.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
