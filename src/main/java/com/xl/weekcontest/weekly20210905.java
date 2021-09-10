package com.xl.weekcontest;

import java.util.*;

/**
 * @ClassName : weekly20210905
 * @Author : Xulian
 * @Date : 2021/9/5 10:57
 */
public class weekly20210905 {
    public static int numberOfWeakCharacters(int[][] properties) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int ans = 0;
        int cur = 0;
        List<int[]> list = new ArrayList<>();
        for (int[] p : properties) {
            if (cur != p[0]) {
                cur = p[0];
                for (int i = 0; i < list.size(); i++) {
                    pq.add(list.get(i));
                }
                list.clear();
            }
            while (!pq.isEmpty() && pq.peek()[1] < p[1]) {
                ans++;
                pq.poll();
            }
            list.add(p);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] p = new int[][]{{1, 5}, {10, 4}, {4, 3}};
//        int[][] p = new int[][]{{5,5},{6,3},{3,6}};
//        int[][] p = new int[][]{{2,2},{3,3}};
        int ans = numberOfWeakCharacters(p);
        System.out.println(ans);
    }
}
