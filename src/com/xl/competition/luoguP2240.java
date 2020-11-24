package com.xl.competition;

import java.util.*;

/**
 * @ClassName : luoguP2240
 * @Author : Xulian
 * @Date : 2020/11/23 23:04
 */
public class luoguP2240 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), T = s.nextInt();
        double[][] heaps = new double[n][2];
        for (int i = 0; i < n; i++) {
            heaps[i][0] = s.nextInt();
            heaps[i][1] = s.nextInt();
        }
        Arrays.sort(heaps, (o1, o2) -> {
            double s1 = o2[1] / o2[0], y1 = o2[1] % o2[0];
            double s2 = o1[1] / o1[0], y2 = o1[1] % o1[0];
            if (s1 < s2) {
                return -1;
            } else if (s1 > s2) {
                return 1;
            } else {
                return Double.compare(y1, y2);
            }

        });
        double val = 0;
        for (double[] ints : heaps) {
            if (T == 0) break;
            if (ints[0] <= T) {
                val += (int) ints[1];
                T -= (int) ints[0];
            } else {
                val += (double) T / (double) ints[0] * (double) ints[1];
                T = 0;
            }
        }

        System.out.printf("%.2f", val);

    }

}
