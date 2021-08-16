package com.xl.tencent;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName : Question
 * @Author : Xulian
 * @Date : 2021/4/5 16:08
 */
public class Question {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int k = 0; k < T; k++) {
            int n = scan.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scan.nextInt();
            }
            if (n == 1) {
                System.out.println(a[0]);
                continue;
            } else if (n == 2) {
                System.out.println(Math.max(a[0], a[1]));
                continue;
            } else if (n == 3) {
                System.out.println(a[0] + a[1] + a[2]);
                continue;
            }
            Arrays.sort(a);
            int s = 0;
            for (int i = n - 1; i > 0; i -= 2) {
                if (i == 2) s += a[i] + a[i - 1] + a[i - 2];
                else if (i == 1) s += Math.max(a[i], a[i - 1]);
                else if (a[i - 1] + a[0] > a[1] * 2) s += a[1] * 2 + a[i] + a[0];
                else s += a[0] + a[i - 1] + a[i] + a[0];
            }
            System.out.println(s);
        }
//        2
//        3
//        3 6 9
//        4
//        10 1 5 2
        // 1 2 5 10

//        18
//        17

    }
}
