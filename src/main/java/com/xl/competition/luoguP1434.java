package com.xl.competition;

import java.io.*;
import java.util.*;

public class luoguP1434 {
    public static int dfs(int x, int y, int[][] height, int[][] mem, int[] dx, int[] dy) {
        if (mem[x][y] != 0) return mem[x][y];
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (tx >= 0 && ty >= 0 && tx < height.length && ty < height[0].length && height[tx][ty] < height[x][y]) {
                max = Math.max(dfs(tx, ty, height, mem, dx, dy) + 1, max);
            }
        }
        mem[x][y] = max;
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] height = new int[m][n];
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = scanner.nextInt();
            }
        }
        int ans = 0;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mem[i][j] == 0) dfs(i, j, height, mem, dx, dy);
                ans = Math.max(ans, mem[i][j]);
            }
        }
        System.out.println(ans);
    }
}
