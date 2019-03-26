package com.jsj.mythreadtest.HandlerNew;

public class MessageQueue {
    private static final String TAG = MessageQueue.class.getName();
    Message[] mItems;


    public MessageQueue() {
        mItems = new Message[50];
    }

    /**
     * 消息队列取消息 出队
     *
     * @return
     */
    Message next() {
        return null;
    }

    /**
     * 添加消息进队列
     *
     * @param message
     */

    public void enqueueMessage(Message message) {
    }
}