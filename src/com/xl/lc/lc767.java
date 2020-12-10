package com.xl.lc;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @ClassName : lc767
 * @Author : Xulian
 * @Date : 2020/11/30 21:20
 */
public class lc767 {
    public class Item {
        int nums;
        char c;

        Item(int nums, char c) {
            this.nums = nums;
            this.c = c;
        }
    }

    public String reorganizeString(String S) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.nums - o1.nums);
        int[] c = new int[26];
        for (int i = 0; i < S.length(); i++) {
            c[S.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (c[i] != 0) {
                Item item = new Item(c[i], (char) (i + 'a'));
                priorityQueue.add(item);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Item item, item1;
        while (priorityQueue.size() >= 2) {
            item = priorityQueue.poll();
            stringBuilder.append(item.c);
            item.nums--;

            item1 = priorityQueue.poll();
            item1.nums--;
            stringBuilder.append(item1.c);
            if (item1.nums > 0) priorityQueue.offer(item1);
            if (item.nums > 0) priorityQueue.offer(item);
        }
        while (priorityQueue.size() != 0) {
            stringBuilder.append(priorityQueue.poll().c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        String res = new lc767().reorganizeString(s);
        System.out.println(res);
    }
}
