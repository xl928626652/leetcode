package com.xl.lc;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @ClassName : lc1675
 * @Author : Xulian
 * @Date : 2021/2/25 11:39
 */
public class lc1675 {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num % 2 == 0 ? num : num * 2);
        }
        for (int i : set) System.out.println(i);
        int res = set.last() - set.first();
        while (res > 0 && set.last() % 2 == 0) {
            int max = set.last();
            set.remove(max);
            set.add(max / 2);
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }

    public static void main(String[] args) {
//        treeSetDemo();
//        pqDemo();
    }

    private static void pqDemo() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            pq.offer(i);
        }
//        pq.remove()
        pq.offer(3);
        //     0
        //    1  2
        //   3 4 5 6
        // 7 8 9  5
//        while()
        System.out.println(pq);
    }

    private static void treeSetDemo() {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        set.add(5);
        System.out.println(set);
    }
}
