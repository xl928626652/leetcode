package com.xl.msjd;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1720 {
    static class MedianFinder {
        private Queue<Integer> maxHeap;
        private Queue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.size() > minHeap.size()){
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }else{
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if(maxHeap.size() > minHeap.size()){
                return maxHeap.peek();
            }else if(minHeap.size() > maxHeap.size()){
                return minHeap.peek();
            }else{
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
//        System.out.println(res);

    }
}
