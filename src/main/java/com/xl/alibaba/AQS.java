package com.xl.alibaba;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : AQS
 * @Author : Xulian
 * @Date : 2021/3/8 22:48
 */
public class AQS {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        CountDownLatch lock1 = new CountDownLatch(5);
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
    }
}
