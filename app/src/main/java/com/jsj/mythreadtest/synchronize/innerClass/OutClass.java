package com.jsj.mythreadtest.synchronize.innerClass;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/6/12.
 */

public class OutClass {
    public static class Inner {
        public void method1(InnerClass2 class2) {
            synchronized (class2) {
                for (int i = 0; i <= 10; i++) {
                    Log.e("Inner", Thread.currentThread().getName() + "i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


        public synchronized void method2() {
            for (int i = 11; i <= 20; i++) {
                Log.e("Inner", Thread.currentThread().getName() + "i=" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class InnerClass2{
        public synchronized void method1(){
            for (int k = 0; k < 10; k++) {
                Log.e("Inner", Thread.currentThread().getName() + "k=" + k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
