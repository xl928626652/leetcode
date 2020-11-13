package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1724_Mark_Hard {
    //里面的知识点很多，有最大股票利润，有最长子序和 还有前缀和。
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        int[] res = new int[]{0, 0, 0, 0};
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i-1][j-1];
            }
        }
        //O(n ^ 3)
        for (int i = 1; i < m + 1; i++) {//转换到股票问题，O(N^3)
            for (int j = 0; j < i; j++) {
                int start = 0;
                for (int k = 1; k < n + 1; k++) {
                    int cur = preSum[i][k] - preSum[j][k] - preSum[i][start] + preSum[j][start];
                    if (cur > max) {
                        max = cur;
                        res = new int[]{j, start, i - 1, k - 1};
                    }
                    if (cur < 0) start = k;
                }
            }
        }
        //O(n^4)
        // for (int i = 1; i < m + 1; i++) {
        //     for (int j = 1; j < n + 1; j++) {
        //         for (int k = 0; k < i; k++) {
        //             for (int l = 0; l < j; l++) {
        //                 if (preSum[i][j] - preSum[i][l] - preSum[k][j] + preSum[k][l] > max) {
        //                     max = preSum[i][j] - preSum[i][l] - preSum[k][j] + preSum[k][l];
        //                     res = new int[]{k, l, i - 1, j - 1};
        //                 }
        //             }
        //         }
        //     }
        // }
        return res;
    }
}
