package com.xl.lc;

import com.xl.base.UnionFind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class lc778H {
    //BFS+PriorityQueue 这道题很巧妙用优先权队列
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        boolean[][] visit = new boolean[n][m];
        pq.add(new int[]{0, 0, grid[0][0]});
        visit[0][0] = true;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[0];
            int j = top[1];
            int hi = top[2];
            if (i == n - 1 && j == n - 1) return hi;
            for (int k = 0; k < 4; k++) {
                int dx = i + dirs[k];
                int dy = j + dirs[k + 1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m || visit[dx][dy]) continue;
                visit[dx][dy] = true;
                int max = Math.max(hi, grid[dx][dy]);
                pq.add(new int[]{dx, dy, max});
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            return o1 - o2;
        }));
//        pq.add(1);
//        pq.add(2);
//        pq.add(7);
//        pq.add(4);
//        pq.add(6);
//        pq.add(5);
        pq.add(1);
        pq.add(5);
        pq.add(3);
        pq.add(4);
        pq.add(2);
        pq.add(7);
        pq.add(6);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }
}
