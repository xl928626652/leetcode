package com.xl.alibaba;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : ProConReentrantlock
 * @Author : Xulian
 * @Date : 2021/3/7 11:25
 */
class Good {
    private int good = 1;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public void increse() {
        lock.lock();
        try {
            //判断
            while (good == 1) {
                c1.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName() + " : " + good);
            good++;
            //通知
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrease() {
        lock.lock();
        try {
            while (good == 0) {
                c2.await();
            }
            //干活
            System.out.println(Thread.currentThread().getName() + " : " + good);
            good--;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

public class ProConReentrantlock {
    public static void main(String[] args) {
        Good good = new Good();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    good.increse();
                }
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    good.decrease();
                }
            }
        }, "B");
        t1.start();
        t2.start();
    }
}
