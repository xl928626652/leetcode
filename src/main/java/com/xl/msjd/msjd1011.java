package com.xl.msjd;

/**
 * @ClassName : msjd1005
 * @Author : Xulian
 * @Date : 2020/10/4 18:43
 */
public class msjd1011 {
    //很巧妙的方法,而且 判断奇偶的方法是（number & 1）
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (((i & 1) == 0 && nums[i] < nums[i - 1]) || ((i & 1) == 1 && nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }
}
