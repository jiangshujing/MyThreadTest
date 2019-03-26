package com.jsj.mythreadtest.HandlerNew;

import android.os.Handler;

/**
 * Created by jiangshujing on 2018/4/3.
 */

public class Message {
    //处理该消息的 Handler
    Handler target;
    public int what;
    public int arg1;
    public int arg2;
    public Object obj;
    public long when;

    public Message next;

    @Override
    public String toString() {
        return obj.toString();
    }
}
