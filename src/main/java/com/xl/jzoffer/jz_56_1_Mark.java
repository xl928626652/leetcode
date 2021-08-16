package com.xl.jzoffer;

public class jz_56_1_Mark {
    public int[] singleNumbers(int[] nums) {
        int xorNumber = nums[0];
        for (int k = 1; k < nums.length; k++) {
            xorNumber ^= nums[k];
        }
        int onePosition = xorNumber & (-xorNumber);
        int ans1 = 0, ans2 = 0; // 初始值为0，所以return new int[] {ans1, ans2};里面的ans1和ans2还要 ^0.
        //如果初始值为10 那么return new int[] {ans1 ^ 10 , ans2 ^ 10}
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & onePosition) == onePosition) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];
            }
        }

        return new int[]{ans1, ans2};
    }


    public static void main(String[] args) {
        //-1-1
        /*
         * -1：1000 0001 -> 1111 1110 -> 1111 1111
         *   1111 1111
         * + 1111 1111
         * -------------
         *  11111 1110 舍弃溢出的那位 -> 1111 1110
         *   1000 0001 -> 1000 0010*/
        /*
         * 计算机补码运算之后的结果还是补码，所以需要转换*/
        int a = -6;
        System.out.println(0 ^ 0);
    }
}
