package com.xl.alibaba;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName : LockSupportDemo
 * @Author : Xulian
 * @Date : 2021/4/1 13:51
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
        System.out.println("here");
    }
}
