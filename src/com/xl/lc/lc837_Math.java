package com.xl.lc;

/**
 * @ClassName : lc837
 * @Author : Xulian
 * @Date : 2020/11/22 21:14
 */
public class lc837_Math {
    //超时
    double p = 0.0;

    public double new21Game(int N, int K, int W) {
        pick(N, K, W, 0, 0);
        return p;
    }

    public void pick(int N, int K, int W, int drawCount, int cur) {
        if (cur >= K) {
            if (cur <= N) {
                p += Math.pow((1.0 / W), drawCount);
            }
            return;
        }
        for (int i = 1; i <= W; i++) {
            pick(N, K, W, drawCount + 1, cur + i);
        }
    }
    //dp法
//    public double new21Game(int N, int K, int W) {
//        // 先判断 K - 1 + W 是否在 N 的里面，如果在的话，说明肯定能赢得游戏，返回 1.0，也就是 100%
//        if (N - K + 1 >= W) {
//            return 1.0;
//        }
//        double[] dp = new double[K + W];
//        // 将能赢得游戏的点数的概率设置为 1
//        for (int i = K; i <= N; i++) {
//            dp[i] = 1.0;
//        }
//        // 计算K + W 这几个点数的概率和
//        double sumProb = N - K + 1;
//        // 从 K - 1 开始计算，
//        for (int i = K - 1; i >= 0; i--) {
//            // 点数为 i 的赢得游戏的概率为 i + 1 ~ i + W 的概率和除以 W
//            dp[i] = sumProb / W;
//            sumProb = sumProb - dp[i + W] + dp[i];
//        }
//
//        return dp[0];
//    }


    public static void main(String[] args) {
        int N = 21, K = 17, W = 10;
        System.out.println(new lc837_Math().new21Game(N, K, W));
    }
}
