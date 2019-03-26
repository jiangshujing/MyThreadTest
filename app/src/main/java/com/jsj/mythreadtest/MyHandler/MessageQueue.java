//package com.jsj.mythreadtest.MyHandler;
//
//import android.os.SystemClock;
//import android.util.Log;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * Created by jiangshujing on 2018/4/3.
// */
//
//public class MessageQueue {
//    Lock lock;
//    Condition mEmptyQueue;
//    Condition mFullQueue;
//    //消息
//    Message mMessages;
//    //装入和取出消息的下标
//    int putIndex;
//    int takeIndex;
//    //记录数 用于判断是否继续生产和消费
//    int count;
//
//    public MessageQueue() {
////        mMessages = new Message[50];//初始化50个消息
//        lock = new ReentrantLock();
//        //条件
//        mEmptyQueue = lock.newCondition();
//        mFullQueue = lock.newCondition();
//    }
//
//    //生产者 子线程
////    final void enqueueMessage(Message msg,long when) {
////        //添加至消息队列
////        try {
////            Message p = mMessages;
////            lock.lock();
//////            while (count == mMessages.length) {
//////                mFullQueue.await();//队列满了，进行等待消息处理
//////            }
////
////            // 第一次添加数据到队列中，或者当前 msg 的时间小于 mMessages 的时间
////            if (p == null || when == 0 || when < p.when) {
////                // New head, wake up the event queue if blocked.
////                // 把当前 msg 添加到链表的第一个
////                msg.next = p;
////                mMessages = msg;
////                mFullQueue.await();//队列满了，进行等待消息处理
//////                needWake = mBlocked;
////            } else {
////                Message prev;
////                for (;;) {
////                    // 不断的遍历找到合适的位置
////                    prev = p;
////                    p = p.next;
////                    if (p == null || when < p.when) {
////                        break;
////                    }
//////                    if (needWake && p.isAsynchronous()) {
//////                        needWake = false;
//////                    }
////                }
////                // 把当前 msg 插入到列表中
////                msg.next = p; // invariant: p == prev.next
////                prev.next = msg;
////                //通知主线程继续执行
////                mEmptyQueue.signalAll();//消息队列不为空，通知next方法来处理消息
////            }
////
////
////
////
//////            mMessages[putIndex] = msg;
//////            putIndex = (++putIndex == mMessages.length ? 0 : putIndex);
//////            count++;
////            //通知主线程继续执行
//////            mEmptyQueue.signalAll();//消息队列不为空，通知next方法来处理消息
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        } finally {
////            lock.unlock();
////        }
////    }
//
//
//    final boolean enqueueMessage(Message msg, long when) {
//        synchronized (this) {
//            msg.when = when;
//            Message p = mMessages;
//            if (p == null || when == 0 || when < p.when) {
//                // New head, wake up the event queue if blocked.
//                msg.next = p;
//                mMessages = msg;
//            } else {
//                Message prev;
//                for (;;) {
//                    prev = p;
//                    p = p.next;
//                    if (p == null || when < p.when) {
//                        break;
//                    }
//                }
//                msg.next = p; // invariant: p == prev.next
//                prev.next = msg;
//            }
//        }
//        return true;
//    }
//
//
//
//    //消费者 主线程
//    final Message next() {
//        //取出消息
//        int pendingIdleHandlerCount = -1; // -1 only during first iteration
//        for (; ; ) {
//            synchronized (this) {
//                // Try to retrieve the next message.  Return if found.
//                final long now = SystemClock.uptimeMillis();
//                Message prevMsg = null;
//                Message msg = mMessages;
//                if (msg != null && msg.target == null) {
//                    // Stalled by a barrier.  Find the next asynchronous message in the queue.
//                    do {
//                        prevMsg = msg;
//                        msg = msg.next;
//                    } while (msg != null);
//                }
//                if (msg != null) {
//                    if (now < msg.when) {//还没到时间
//                        // Next message is not ready.  Set a timeout to wake up when it is ready.
//                    } else {
//                        if (prevMsg != null) {
//                            prevMsg.next = msg.next;
//                        } else {
//                            mMessages = msg.next;
//                        }
//                        msg.next = null;
//                        return msg;
//                    }
//                } else {
//                    // No more messages.
//                    Log.e("MessageQueue", "No more messages");
//                }
//                if (pendingIdleHandlerCount <= 0) {
//                    continue;
//                }
//            }
//        }
//    }
//
//    //消费者 主线程
//    final Message next() {
//        //取出消息
//        Message message = null;
//        try {
//            lock.lock();
//            //取到最后一个
//            while (count == 0) {
//                try {
//                    mEmptyQueue.await();//没有消息，等待
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            message = mMessages[takeIndex];//取消息
//            mMessages[takeIndex] = null;//取出后将位置置空
//            takeIndex = (++takeIndex == mMessages.length ? 0 : takeIndex);
//            count--;
//            //通知子线程
//            mFullQueue.signalAll();
//        } finally {
//            lock.unlock();
//        }
//
//        return message;
//    }
//}
