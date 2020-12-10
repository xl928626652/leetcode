package com.xl.base;

/**
 * @ClassName : Main
 * @Author : Xulian
 * @Date : 2020/11/30 22:12
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 66
 * 44        55
 * 44    22   44    33
 * 22  22  (44)
 */

class MyInteger {
    // 插入顺序
    int order;
    int value;

    public MyInteger(int order, int value) {
        this.order = order;
        this.value = value;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyInteger{" +
                "order=" + order +
                ", value=" + value +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // 创建一个优先级队列
        PriorityQueue<MyInteger> priorityQueue = new PriorityQueue<>(new Comparator<MyInteger>() {
            @Override
            public int compare(MyInteger o1, MyInteger o2) {
                return o2.value - o1.value;
            }
        });

        // 插入10个元素
        priorityQueue.offer(new MyInteger(1, 66));

        priorityQueue.offer(new MyInteger(2, 44));
        priorityQueue.offer(new MyInteger(3, 55));

        priorityQueue.offer(new MyInteger(4, 44));
        priorityQueue.offer(new MyInteger(5, 22));
        priorityQueue.offer(new MyInteger(6, 44));
        priorityQueue.offer(new MyInteger(7, 33));

        priorityQueue.offer(new MyInteger(8, 22));
        priorityQueue.offer(new MyInteger(9, 22));

        priorityQueue.offer(new MyInteger(10, 44));

        while (!priorityQueue.isEmpty()) {
            // 依次从队列中取出元素并打印
            System.out.println(priorityQueue.poll());
        }
        System.out.println();
    }
}

