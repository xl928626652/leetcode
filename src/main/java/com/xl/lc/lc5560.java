package com.xl.lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : lc5560
 * @Author : Xulian
 * @Date : 2020/11/28 22:43
 */
public class lc5560 {
    class FrontMiddleBackQueue {
        Deque<Integer> first, second;

        public FrontMiddleBackQueue() {
            first = new LinkedList<>();
            second = new LinkedList<>();
        }

        public void pushFront(int val) {
            first.offerFirst(val);
            while (first.size() >= second.size() + 2) second.offerFirst(first.pollLast());
        }

        public void pushMiddle(int val) {
            first.offerLast(val);
            while (first.size() >= second.size() + 2) {
                second.offerFirst(first.pollLast());
            }

        }

        public void pushBack(int val) {
            second.offerLast(val);
            while (second.size() > first.size()) {
                first.offerLast(second.pollFirst());
            }

        }

        public int popFront() {
            if (first.size() == 0) return -1;
            if (first.size() == second.size()) first.offerLast(second.pollFirst());
            return first.pollFirst();
        }

        public int popMiddle() {
            if (first.size() == 0) return -1;
            int res = first.peekLast();
            if (first.size() == second.size()) {
                first.pollLast();
                first.offerLast(second.pollFirst());
            }
            return res;
        }

        public int popBack() {
            if (first.size() == 0) return -1;
            if (second.size() == 0) {
                return first.pollLast();
            } else {
                int res = second.pollLast();
                if (first.size() >= second.size() + 2) {
                    second.offerFirst(first.pollLast());
                }
                return res;
            }
        }
    }

}
