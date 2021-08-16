package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1704 {
    //    public int missingNumber(int[] nums) {
//        int sum = (1 + nums.length) * nums.length / 2;
//        for (int i : nums){
//            sum -= i;
//        }
//        return sum;
//    }
    //
    //这这种解答真的秒，用异或
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
