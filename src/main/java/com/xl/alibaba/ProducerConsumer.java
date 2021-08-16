package com.xl.alibaba;

/**
 * @ClassName : xujiahuanxing
 * @Author : Xulian
 * @Date : 2021/3/7 11:22
 */
class Number {

    private int num = 0;

    public synchronized void decrease() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + " ... " + num);
        this.notifyAll();
    }

    public synchronized void increase() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + " ... " + num);
        this.notifyAll();
    }

}

public class ProducerConsumer {
    public static void main(String[] args) {
        /**
         * 要求一个线程增加，一个线程减少
         */
        Number number = new Number();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    number.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    number.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    number.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    number.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
