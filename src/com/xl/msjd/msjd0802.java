package com.xl.msjd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class msjd0802 {
    List<List<Integer>> lists;
    boolean[][] booleans;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        lists = new ArrayList<>();
        booleans = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        recur(0, 0, obstacleGrid);
        return lists;
    }

    public void recur(int i, int j, int[][] obstacleGrid) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || booleans[i][j] || obstacleGrid[i][j] == 1 || lists.size() >= (obstacleGrid.length + obstacleGrid[0].length - 1))
            return;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        booleans[i][j] = true;

        lists.add(new ArrayList<>(list));
        for (int k = 0; k < 2; k++) {

            if (k == 0) {
                recur(i + 1, j, obstacleGrid);
            } else {
                recur(i, j + 1, obstacleGrid);
            }

        }

        if (lists.size() < (obstacleGrid.length + obstacleGrid[0].length - 1)) {
            lists.remove(lists.size() - 1);
        }

    }
}
