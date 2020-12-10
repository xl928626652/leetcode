package com.xl.base;

import java.util.Arrays;

/**
 * @ClassName : RadixSort
 * @Author : Xulian
 * @Date : 2020/11/26 23:45
 */
public class RadixSort {
    public int[] maximumGap(int[] nums) {
        int n = nums.length;
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();
        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }

            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;

        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 5, 1, 6, 2, 4, 9, 8, 7};
        int[] res = new RadixSort().maximumGap(arr);
        System.out.println(Arrays.toString(res));
    }
}
