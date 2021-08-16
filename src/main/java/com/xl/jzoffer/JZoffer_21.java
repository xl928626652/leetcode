package com.xl.jzoffer;

public class JZoffer_21 {
    public int[] exchange(int[] nums) {
        int i= 0;
        int j= nums.length-1;
        int temp;
        while (i<j)
        {
            if(nums[i] % 2 ==0 && nums[j] % 2 ==1)
            {
                temp=nums[i];
                nums[i++]=nums[j];
                nums[j--]=temp;
            }else if (nums[i] % 2 != 0){
                i++;
            }else if (nums[j] % 2 != 1){
                j--;
            }
        }
        return nums;
    }
    //别人的答案，挺好的
    public int[] exchange_new(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) i++;
            while(i < j && (nums[j] & 1) == 0) j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }


}
