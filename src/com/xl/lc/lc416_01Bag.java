package com.xl.lc;

/**
 * @ClassName : lc416
 * @Author : Xulian
 * @Date : 2020/9/30 12:51
 */
public class lc416_01Bag {
    //二维dp矩阵
//    public boolean canPartition(int[] nums) {
//        int len = nums.length;
//        if (nums.length == 0) return true;
//
//        int sum = 0;
//        for (int i : nums) {
//            sum += i;
//        }
//        if (sum % 2 != 0) return false;
//        int target = sum / 2;
//
//        boolean[][] dp = new boolean[len][target + 1];
//        dp[0][0] = true;
//        if (nums[0] <= target) dp[0][nums[0]] = true;
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < target + 1; j++) {
//                if (nums[i] == j) {
//                    dp[i][j] = true;
//                }
//                if (nums[i] < j) {
//                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
//                }
//                if (nums[i] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//            if(dp[i][target]) return true;//剪枝操作
//        }
//        return dp[len - 1][target];
//    }
    //一维dp矩阵,从后到前
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (nums.length == 0) return true;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
}
