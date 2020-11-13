package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc5540
 * @Author : Xulian
 * @Date : 2020/11/1 15:32
 */
public class lc5540 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        Arrays.sort(points,(o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] - points[i-1][0] > max){
                max = points[i][0] - points[i-1][0];
            }
        }
        return max;
    }
}
