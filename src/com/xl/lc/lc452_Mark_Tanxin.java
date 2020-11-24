package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc452
 * @Author : Xulian
 * @Date : 2020/11/23 17:06
 */
public class lc452_Mark_Tanxin {
    //很好的一道贪心题
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int left = points[0][1];
        int count = 1;
        for (int[] ints : points) {
            if (ints[0] > left) {
                count++;
                left = ints[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(new lc452_Mark_Tanxin().findMinArrowShots(points));
    }
}
