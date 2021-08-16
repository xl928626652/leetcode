package com.xl.alibaba;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName : Deadlock
 * @Author : Xulian
 * @Date : 2021/3/25 14:09
 */
class DeadlockThread implements Runnable {

    String a, b;

    DeadlockThread(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a) {
            System.out.println(Thread.currentThread().getName() + "持有了" + a + "尝试获得" + b);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "获得了" + b + "已经获得了两个锁");
            }
        }
    }
}

public class Deadlock {
    public static void main(String[] args) {
        String a = "aaa", b = "bbb";
        Thread t1 = new Thread(new DeadlockThread(a, b), "AB");
        Thread t2 = new Thread(new DeadlockThread(b, a), "BA");
        t1.start();
        t2.start();
        System.out.println("here");
    }
}
