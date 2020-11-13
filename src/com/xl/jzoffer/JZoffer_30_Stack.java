package com.xl.jzoffer;


import java.util.Stack;

public class JZoffer_30_Stack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public JZoffer_30_Stack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        stack1.push(x);
        //先判断空，再判断栈顶是否大于x，就用（1st || 2nd）来做
        if(stack2.isEmpty() ||stack2.peek() >= x) stack2.push(x);
    }

    public void pop() {
        //这里要用.equals 因为Stack<Integer> stack1;是用的int的包装类定义的，所以不能直接比地址。
        if(stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
