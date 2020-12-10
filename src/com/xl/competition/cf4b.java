package com.xl.competition;

import java.util.*;

/**
 * @ClassName : cf4b
 * @Author : Xulian
 * @Date : 2020/12/10 18:13
 */
public class cf4b {

    public static class Main {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int d = s.nextInt(), sum = s.nextInt();
            int[][] day = new int[d][2];
            int more = 0;
            int[] ans = new int[d];
            boolean flag = false;
            for (int i = 0; i < d && !flag; i++) {
                day[i][0] = s.nextInt();
                day[i][1] = s.nextInt();
                sum -= day[i][0];
                more += day[i][1] - day[i][0];
                ans[i] = day[i][0];
                if (sum < 0) {
                    System.out.println("NO");
                    flag = true;
                }
            }
            if (sum > more && !flag) {
                System.out.println("NO");
            } else if (!flag) {

                for (int i = 0; i < d; i++) {
                    int diff = day[i][1] - day[i][0];
                    if (sum >= diff) {
                        ans[i] = day[i][1];
                        sum -= diff;
                    } else {
                        ans[i] += sum;
                        sum = 0;
                        break;
                    }
                }
                System.out.println("YES");
                for (int i : ans) {
                    System.out.print(i + " ");
                }

            }

        }
    }
}
