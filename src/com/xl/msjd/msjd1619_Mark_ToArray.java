package com.xl.msjd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1619_Mark_ToArray {
    boolean[][] visited;
    List<Integer> list;
    //这道题很好，可以不用visited，把水域里0的置成非0的数就可以了。
    //list转int[] 用这个trick
    public int[] pondSizes(int[][] land) {
        list = new ArrayList<>();
        visited = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int res = recur(land, i, j);
                if (res != 0) {
                    list.add(res);
                }
            }
        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        Arrays.sort(res);
        //https://leetcode-cn.com/problems/pond-sizes-lcci/solution/java-dfsqiu-jie-chi-tang-mian-ji-by-ggeorge500/
        int[] res = list.stream().sorted().mapToInt(Integer::valueOf).toArray();
        return res;


    }

    public int recur(int[][] land, int i, int j) {
        if (i < 0 || i > land.length - 1 || j < 0 || j > land[0].length - 1 || land[i][j] != 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + recur(land, i - 1, j) + recur(land, i, j - 1) + recur(land, i, j + 1) + recur(land, i + 1, j) + recur(land, i + 1, j + 1) + recur(land, i - 1, j + 1) + recur(land, i + 1, j - 1) + recur(land, i - 1, j - 1);
    }
}
