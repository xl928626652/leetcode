package com.xl.lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : lc402
 * @Author : Xulian
 * @Date : 2020/11/18 9:55
 */
public class lc402 {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        Deque<Character> mono = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i == 0) mono.offerLast(num.charAt(i));
            else {
                while (!mono.isEmpty() && num.charAt(i) < mono.peek() && k > 0) {
                    k--;
                    mono.pollLast();
                }
                mono.offerLast(num.charAt(i));
            }
        }
        for (int i = 0; i < k; i++) {
            mono.pollLast();
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (!mono.isEmpty()) {
            if (flag && mono.peekFirst() == '0') {
                mono.pollFirst();
                continue;
            }
            flag = false;
            sb.append(mono.pollFirst());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
