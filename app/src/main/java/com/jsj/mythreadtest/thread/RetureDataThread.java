package com.jsj.mythreadtest.thread;

import java.util.concurrent.Callable;

/**
 * Created by jsj on 2018/4/25.
 * 线程返回值
 * 1. 必须实现Callable接口
 * 2. 必须使用ExecutorService的submit方法来执行，返回一个Future对象
 * 3. 可以使用isDone()方法检测future是否完成，完成后可以调用get()方法获得future的值
 * 4. 如果直接调用get()方法，get()方法将阻塞值线程结束
 */
public class RetureDataThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "返回值";
    }
}
