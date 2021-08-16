package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc1356
 * @Author : Xulian
 * @Date : 2020/11/6 13:56
 */
public class lc1356 {
    public int[] sortByBits(int[] arr) {
        int[][] arrnew = new int[arr.length][2];
        for (int i = 0; i < arrnew.length; i++) {
            arrnew[i][0] = arr[i];
            arrnew[i][1] = countOne(arr[i]);
        }
        Arrays.sort(arrnew, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrnew[i][0];
        }
        return arr;
    }

    public int countOne(int num) {
        int count = 0;
        while (num != 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
}
