package com.xl.jzoffer;

public class JZoffer_47 {
    //以后用row和column的命名 更简单
    public int maxValue(int[][] grid) {
        int length = grid[0].length;
        int width = grid.length;
        int[][] dp = new int[width + 1][length + 1];
        dp[0][0] = 0;
        for (int i = 1; i < width + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[width][length];
    }

    public static void main(String[] args) {
        JZoffer_47 jZoffer_47 = new JZoffer_47();
        int[][] grid = new int[][]{{1,2,5},{3,2,1}};
        int res=jZoffer_47.maxValue(grid);
        System.out.println(res);
    }
}
