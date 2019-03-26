//package com.jsj.mythreadtest.MyHandler;
//
//import android.os.MessageQueue;
//import android.util.Log;
//
///**
// * Created by jiangshujing on 2018/4/3.
// */
//
//public class Looper {
//
//    static ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
//    MessageQueue mQueue;
//
//    private Looper() {
//        mQueue = new MessageQueue();//创建消息队列
//    }
//
//    public static Looper myLooper() {
//        return sThreadLocal.get();
//    }
//
//    public static void prepare() {
//        if (sThreadLocal.get() != null) {
//            throw new RuntimeException("Only one Looper may be created per thread");
//        }
//
//        sThreadLocal.set(new Looper());
//    }
//
//    public static void loop(){
//        Looper me = myLooper();
//        if(me == null){
//            throw new RuntimeException("No Looper; Looper.prepare() wasn;t called on this thread.");
//        }
//
//        MessageQueue queue = me.mQueue;//获取消息队列
//        for(;;){//死循环，当消息为空时结束本次循环
//            Message msg = queue.next();
//            if(msg == null || msg.target == null){
//                Log.e("Looper", "msg == null || msg.target == null");
//                continue;
//            }
//            //转发给 handler
//            msg.target.dispatchMessage(msg);
//        }
//
//    }
//}
