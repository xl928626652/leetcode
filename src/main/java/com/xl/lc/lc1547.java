package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc1547
 * @Author : Xulian
 * @Date : 2020/12/8 18:51
 */
public class lc1547 {
    //这里把map换成int会快不少
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length + 1;
        int[][] f = new int[len + 1][len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cuts.length; i++) {
            map.put(i + 1, cuts[i]);
        }
        map.put(0, 0);
        map.put(cuts.length + 1, n);
        for (int num = 1; num <= cuts.length + 1; num++) {
            for (int i = 0; i + num <= cuts.length + 1; i++) {
                int start = i, end = i + num;
                if (num == 1) {
                    f[start][end] = map.get(end) - map.get(start);
                } else {
                    f[start][end] = Integer.MAX_VALUE;
                    for (int j = start + 1; j < end; j++) {
                        if (j - start != 1 && end - j != 1) {
                            f[start][end] = Math.min(f[start][j] + f[j][end] + map.get(end) - map.get(start), f[start][end]);
                        } else if (j - start == 1 && end - j != 1) {
                            f[start][end] = Math.min(f[start][j] + f[j][end] + map.get(end) - map.get(j), f[start][end]);
                        } else if (end - j == 1 && j - start != 1) {
                            f[start][end] = Math.min(f[start][j] + f[j][end] + map.get(j) - map.get(start), f[start][end]);
                        } else {
                            f[start][end] = f[start][j] + f[j][end];
                        }
                    }
                }
            }
        }
        return f[0][cuts.length + 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = new int[]{1, 3, 4, 5};
        int ans = new lc1547().minCost(n, cuts);
        System.out.println(ans);
    }
}
