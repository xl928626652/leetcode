package com.xl.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc5553_Mark {
    public boolean canDistribute(int[] nums, int[] quantity) {
        // 统计五十个数字的个数
        int[] cnt = new int[55];
        Arrays.sort(nums);
        int tot = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) cnt[++tot] = 0;
            cnt[tot] += 1;
        }
        // tot 个不同的数字，每种数字为 cnt[i] 个
        // 统计结束

        /*
            下面状态转移的实质是：dp[s] 集合满足后，当 dp[r] 集合也满足时，可得 dp[s | r] 集合也满足，同时 (s & r) == 0
        */
        int m = quantity.length; // m 位顾客
        int lim = 1 << m;
        boolean[] dp = new boolean[1 << m]; // 状态压缩动态规划 dp[s] 表示满足顾客状态为 s 是否可行
        dp[0] = true;
        for (int i = 1; i <= tot; i++) { // 使用第 i 个数字满足一些顾客
            // s 从 0 开始遍历可以吗？
            for (int s = lim - 1; s >= 0; s--) { // 当前状态已经满足了 s 的顾客 （一个状态）
                if (!dp[s]) continue; // dp[s] 集合是要可满足的
                for (int r = 0; r < lim; r++) { // 当前这个数字要满足 r 的顾客 （也是一个状态)
                    if ((s & r) > 0) continue; // s 与 r 的顾客不能重叠
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        if (((r >> k) & 1) == 1) sum += quantity[k]; // 满足状态 r 的顾客需要多少个数字
                    }
                    if (cnt[i] >= sum) dp[s | r] = true; // 如果当前可以用 i 位数字给顾客，就进行状态转移
                }
            }

        }
        return dp[lim - 1];
    }

//    public boolean canDistribute(int[] nums, int[] quantity) {
//        int n = nums.length;
//        int m = quantity.length;
//        int[] cnt = new int[n];
//        Arrays.sort(nums);
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//            if (i == 0 || nums[i] == nums[i - 1]) {
//                cnt[index]++;
//            } else {
//                cnt[++index]++;
//            }
//        }
//        int lim = 1 << 10;
//        boolean[] dp = new boolean[lim];
//        dp[0] = true;
//        for (int i = 0; i <= index; i++) {
//            for (int s = lim - 1; s > -1; s--) {
//                if (dp[s] == false) continue;
//                for (int r = 0; r < lim; r++) {
//                    if ((s & r) > 0) continue;
//                    int sum = 0;
//                    for (int k = 0; k < m; k++) {
//                        if (((r >> k) & 1) == 1) sum += quantity[k];
//                    }
//                    if (cnt[i] >= sum) dp[s | r] = true;
//                }
//            }
//        }
//        return dp[lim - 1];
//    }
    // 这个模板很好，是最普通的动态规划
    //public boolean canDistribute(int[] nums, int[] quantity) {
    //    int m = quantity.length;
    //    Map<Integer, Integer> map = new HashMap<>();
    //    for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
    //    int[] cnt = new int[map.keySet().size()];
    //    int index = 0;
    //    for(int i : map.keySet()){
    //        cnt[index++] = map.get(i);
    //    }
    //    int n = cnt.length;
    //    boolean[][] dp = new boolean[n + 1][1 << m];
    //    int[] sum = new int[(1 << m)];
    //    for(int i = 1; i < (1 << m); i++){
    //        for(int j = 0; j < m; j++){
    //            if((i & (1 << j)) > 0){
    //                sum[i] = sum[i - (1 << j)] + quantity[j];
    //            }
    //        }
    //    }
    //    for(int i = 0; i <= n;i++){
    //        dp[i][0] = true;
    //    }
    //    for(int i = 1; i <= cnt.length; i++){
    //        for(int mask = 0; mask < (1 << m); mask++){
    //            if(dp[i - 1][mask]){
    //                dp[i][mask] = true;
    //                continue;
    //            }
    //            for(int s = mask; s > 0; s = ((s - 1) & mask)){
    //                int left = mask - s;
    //                boolean sub = dp[i - 1][left];
    //                boolean other = (sum[s] <= cnt[i - 1]);
    //                if(sub && other){
    //                    dp[i][mask] = true;
    //                    break;
    //                }
    //            }
    //        }
    //    }
    //    return dp[n][(1 << m) - 1];
    //}
}
