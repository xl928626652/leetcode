package com.xl.lc;

/**
 * @ClassName : lc1659
 * @Author : Xulian
 * @Date : 2020/11/17 19:15
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1659_Mark {
    int[][] mask_span = new int[243][6];
    int[][][][] dp = new int[243][6][7][7];
    int[] nx_inner = new int[243];
    int[] wx_inner = new int[243];
    int[] score_inner = new int[243];
    int[][] score_outer = new int[243][243];
    int m, n, n3;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        this.m = m;
        this.n = n;
        n3 = (int) Math.pow(3, n);
        for (int mask = 0; mask < n3; mask++) {
            for (int mask_tmp = mask, i = 0; i < n; i++) {
                mask_span[mask][i] = mask_tmp % 3;
                mask_tmp /= 3;
            }
            nx_inner[mask] = wx_inner[mask] = score_inner[mask] = 0;
            for (int i = 0; i < n; i++) {
                if (mask_span[mask][i] != 0) {
                    if (mask_span[mask][i] == 1) {
                        nx_inner[mask]++;
                        score_inner[mask] += 120;
                    } else {
                        wx_inner[mask]++;
                        score_inner[mask] += 40;
                    }
                    if (i - 1 >= 0) {
                        score_inner[mask] += cal(mask_span[mask][i], mask_span[mask][i - 1]);
                    }
                }
            }
        }
        for (int mask0 = 0; mask0 < n3; mask0++) {
            for (int mask1 = 0; mask1 < n3; mask1++) {
                score_outer[mask0][mask1] = 0;
                for (int i = 0; i < n; i++) {
                    score_outer[mask0][mask1] += cal(mask_span[mask0][i], mask_span[mask1][i]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    for (int l = 0; l < dp[0][0][0].length; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        return dfs(0, 0, introvertsCount, extrovertsCount);
    }

    public int dfs(int mask_last, int row, int nx, int wx) {
        if (row == m || nx + wx == 0) {
            return 0;
        }
        if (dp[mask_last][row][nx][wx] != -1) {
            return dp[mask_last][row][nx][wx];
        }
        int best = 0;
        for (int mask = 0; mask < n3; mask++) {
            if (nx_inner[mask] > nx || wx_inner[mask] > wx) {
                continue;
            }
            int score = score_inner[mask] + score_outer[mask][mask_last];
            best = Math.max(best, score + dfs(mask, row + 1, nx - nx_inner[mask], wx - wx_inner[mask]));
        }
        dp[mask_last][row][nx][wx] = best;
        return dp[mask_last][row][nx][wx];
    }

    public int cal(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if (x == 1 && y == 1) {
            return -60;
        }
        if (x == 2 && y == 2) {
            return 40;
        }
        return -10;
    }

    public static void main(String[] args) {

    }
}
