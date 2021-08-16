package com.xl.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

public class JZoffer_30_Deque_toArray {
    Deque<Integer> stack;
    int min=0;
    public JZoffer_30_Deque_toArray() {
        stack= new LinkedList<Integer>();
    }
    public void push(int x) {
        stack.push(x);
        if(stack.size()==1) min=x;
        if(x<min){
            min=x;
        }
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.getLast();
    }
    public int min() {
        Object[] min=stack.stream().sorted().toArray();
        return (int)min[0];
    }
}
