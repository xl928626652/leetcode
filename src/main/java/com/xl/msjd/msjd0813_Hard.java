package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd0811
 * @Author : Xulian
 * @Date : 2020/10/3 20:53
 */
public class msjd0813_Hard {
    public int pileBox(int[][] box) {
        Arrays.sort(box, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        int[] dp = new int[box.length];
        int res = 0;
        for (int i = 0; i < box.length; ++i) {
            int max = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    max = Math.max(max, dp[j] + box[i][2]);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] box = new int[][]{{1, 1, 1}, {2, 5, 3}, {2, 4, 5}, {3, 4, 5}, {3, 4, 4}};
        Arrays.sort(box, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[2] - o2[2];
                }
            }
        });
        for (int[] ints : box) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + "");
            }
            System.out.println();
        }
    }
}
