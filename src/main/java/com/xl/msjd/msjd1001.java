package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1001
 * @Author : Xulian
 * @Date : 2020/10/4 16:00
 */
public class msjd1001 {
//    public void merge(int[] A, int m, int[] B, int n) {
//        for (int i = 0; i < B.length; i++) {
//            A[i + m] = B[i];
//        }
//        Arrays.sort(A, 0, m + n);
//    }

    public void merge(int[] A, int m, int[] B, int n) {
        int a = m - 1;
        int b = n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[a + b + 1] = A[a];
                a--;
            } else {
                A[a + b + 1] = B[b];
                b--;
            }
        }
        if (b >= 0) {
            for (int i = 0; i <= b; i++) {
                A[i] = B[i];
            }
        }
    }
}
