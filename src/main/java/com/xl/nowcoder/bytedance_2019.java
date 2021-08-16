package com.xl.nowcoder;

/**
 * @ClassName : bytedance_2019
 * @Author : Xulian
 * @Date : 2020/12/18 13:59
 */

import java.util.*;

public class bytedance_2019 {
    //抓捕孔连顺 这个代码为啥有问题
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int N = scan.nextInt(), D = scan.nextInt();
//        int[] bs = new int[N];
//        int mod = 99997867;
//        for (int i = 0; i < bs.length; i++) {
//            bs[i] = scan.nextInt();
//        }
//
//        long ans = 0;
//        int left = 0, right = 2;
//        if(N < 3){
//            System.out.println(0);
//            return;
//        }
//        while (left <= N - 3) {
//            int diff = bs[right] - bs[left];
//            if (diff > D) {
//                left++;
//            } else {
//                if (right - left < 2) {
//                    right++;
//                    if (right == N) break;
//                    else continue;
//                } else {
//                    ans += right - left - 1;
//                    ans %= mod;
//                    if (right < N - 1) right++;
//                    else left++;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
    //Map[]数组的开辟方式，挺有意思的，每个元素都要new 一个Hashmap或者啥的
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = scanner.nextInt();
//            Map<String, Integer>[] maps = new HashMap[n];
//            int max = 1;
//            for (int j = 0; j < n; j++) {
//                maps[j] = new HashMap<>();
//                int nums = scanner.nextInt();
//                for (int k = 0; k < nums * 2; k += 2) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(scanner.nextInt());
//                    sb.append(scanner.nextInt());
//                    if (j >= 1) {
//                        int cur = maps[j - 1].getOrDefault(sb.toString(), 0) + 1;
//                        max = Math.max(max, cur);
//                        maps[j].put(sb.toString(), cur);
//                    } else {
//                        maps[j].put(sb.toString(), 1);
//                    }
//                }
//            }
//            System.out.println(max);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.MAX_VALUE;
        int n = scanner.nextInt();
        int[][] dp = new int[1 << n][n];
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scanner.nextInt();
            }
        }
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        System.out.println(dp[0][0]);
    }
}
