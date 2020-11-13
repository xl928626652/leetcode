package com.xl.msjd;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class msjd0102 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        PriorityQueue<Character> priorityQueue1 = new PriorityQueue<>(Character::compareTo);
        PriorityQueue<Character> priorityQueue2 = new PriorityQueue<>(Character::compareTo);
        for (int i = 0; i < s1.length(); i++) {
            priorityQueue1.add(s1.charAt(i));
            priorityQueue2.add(s2.charAt(i));
        }
//        System.out.println(priorityQueue1.toString());
//        System.out.println(priorityQueue2.toString());
//        return priorityQueue1.toString().equals(priorityQueue2.toString());
        while (!priorityQueue1.isEmpty()) {
            if (priorityQueue1.poll() != priorityQueue2.poll())
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new msjd0102().CheckPermutation("abcdeefabvv", "bvbcadefeva"));

    }
}
