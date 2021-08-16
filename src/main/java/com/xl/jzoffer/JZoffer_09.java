package com.xl.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

public class JZoffer_09 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public JZoffer_09() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }


}
