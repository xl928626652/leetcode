package com.xl.jzoffer;

import java.util.*;

public class JZoffer_41_Mark {
    /*超时代码*/
    /*List<Integer> list;
    *//** initialize your data structure here. *//*
    public JZoffer_41() {
        list=new LinkedList<>();
    }

    public void addNum(int num) {
        if(list.size()==0) {
            list.add(num);
            return;
        }
        if(list.size()==1){
            if(list.get(0)<=num){
                list.add(num);
            }else{
                list.add(0,num);
            }
            return;
        }
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)<=num && list.get(i+1)>=num){
                list.add(i+1,num);
                return;
            }
        }
        if(num<=list.get(0)){
            list.add(0,num);
        }else{
            list.add(num);
        }
    }

    public double findMedian() {
        if(list.size()%2!=0){
            return (double)list.get(list.size()/2);
        }else{
            return ((double)(list.get(list.size()/2-1)+list.get(list.size()/2))/2);
        }
    }
    public void print(){
        for (int i :
                list) {
            System.out.println(i);
        }
    }*/
    Queue<Integer> A, B;
    public JZoffer_41_Mark() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
//        lambda表达式
        B = new PriorityQueue<>((x, y) -> { return (y - x);}); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;///2.0就自动float了
    }




    public static void main(String[] args) {
        /*JZoffer_41 jZoffer_41 = new JZoffer_41();
        System.out.println("******"+"print_1");
        jZoffer_41.print();
        jZoffer_41.addNum(1);
        System.out.println("******"+"print_2");
        jZoffer_41.print();
        jZoffer_41.addNum(2);
        System.out.println("******"+"print_3");
        jZoffer_41.print();
        System.out.println(jZoffer_41.list.size()/2-1);
        System.out.println((jZoffer_41.list.get(0)+jZoffer_41.list.get(1))/2);
        System.out.println(jZoffer_41.findMedian());*/
    }
}
