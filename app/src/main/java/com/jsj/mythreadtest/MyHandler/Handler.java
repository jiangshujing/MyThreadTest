//package com.jsj.mythreadtest.MyHandler;
//
//
//import android.os.Looper;
//import android.os.MessageQueue;
//import android.os.SystemClock;
//
///**
// * Created by jiangshujing on 2018/4/3.
// */
//
//public class Handler {
//    //消息队列
//    MessageQueue mQueue;
//    //Looper
//    Looper mLooper;
//
//    public Handler() {
//        mLooper = Looper.myLooper();
//        if (mLooper == null) {
//            throw new RuntimeException("Can't create handler inside thread that" + "has not called Looper.prepare()");
//        }
//
//        mQueue = mLooper.mQueue;
//    }
//
//    public final void sendMessage(Message msg) {
//        MessageQueue queue = mQueue;
//        if (queue != null) {
//            msg.target = this;
//            queue.enqueueMessage(msg);
//        } else {
//            RuntimeException e = new RuntimeException(this + "sendMessage() called with no mQueue");
//            throw e;
//        }
//    }
//
//    /**
//     * Subclasses must implement this to receive messages.
//     * 主线程接收消息的方法
//     */
//    public void handleMessage(Message msg) {
//
//    }
//
//    public void dispatchMessage(Message msg) {
//        handleMessage(msg);
//    }
//
//    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
//        if (delayMillis < 0) {
//            delayMillis = 0;
//        }
//        //在当前时间加上了延时时间 delaymillis（当前时间 + 延时时间）,由此可以看到，此时变成了绝对时间，即到了绝对的时间，此任务应被处理
//        return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
//    }
//
//    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
//        MessageQueue queue = mQueue;
//        //如果mQueue为null的话，即证明Handler没有绑定Looper
//
//        return enqueueMessage(queue, msg, uptimeMillis);
//    }
//
//    private boolean enqueueMessage(MessageQueue queue, Message msg, long uptimeMillis) {
//        msg.target = this;
////        if (mAsynchronous) {
////            msg.setAsynchronous(true);
////        }
//        return queue.enqueueMessage(msg, uptimeMillis);
//    }
//
//}
