package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc62
 * @Author : Xulian
 * @Date : 2020/12/9 11:32
 */
public class lc62 {
    int[][] ans;

    public int uniquePaths(int m, int n) {
        ans = new int[m][n];
        for (int[] ints : ans) {
            Arrays.fill(ints, -1);
        }
        dfs(0, 0, m, n);
        return ans[0][0];
    }

    public int dfs(int x, int y, int m, int n) {
        if (x >= m || y >= n) {
            return 0;
        } else {
            if (ans[x][y] != -1) {
                return ans[x][y];
            } else {
                int d = dfs(x + 1, y, m, n);
                int r = dfs(x, y + 1, m, n);
                if (d + r == 0) ans[x][y] = 1;
                else {
                    ans[x][y] = d + r;
                }
                return ans[x][y];
            }
        }

    }
}
