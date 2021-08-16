package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc1314
 * @Author : Xulian
 * @Date : 2020/12/3 13:38
 */
public class lc1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];
        for (int i = 1; i < pre.length; i++) {
            for (int j = 1; j < pre[0].length; j++) {
                pre[i][j] = mat[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = j - K, right = j + K, top = i - K, bottom = i + K;
                ans[i][j] = compute(left, right, top, bottom, pre);
            }
        }
        for (int[] ints : pre) {
            System.out.println(Arrays.toString(ints));
        }
        return ans;
    }

    public int compute(int left, int right, int top, int bottom, int[][] pre) {

        if (left < 0) left = 0;
        if (right >= pre[0].length - 1) right = pre[0].length - 2;
        if (top < 0) top = 0;
        if (bottom >= pre.length - 1) bottom = pre.length - 2;
        return pre[bottom + 1][right + 1] + pre[top][left] - pre[bottom + 1][left] - pre[top][right + 1];
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int K = 1;
        int[][] res = new lc1314().matrixBlockSum(mat, K);
        for (int[] ints : res) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
