package com.xl.jzoffer;

public class jz_57_1 {
    //遍历 还是慢了
    /*public int[] twoSum(int[] nums, int target) {
        int res1 = nums[0], res2 = nums[1];
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (flag) break;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res1 = nums[i];
                    res2 = nums[j];
                    flag = true;
                } else if (nums[i] + nums[j] > target) {
                    break;
                }
            }
        }
        return new int[]{res1, res2};
    }*/
    // 这个是对的， 但是不够简洁
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[0];
        int res1 = nums[0], res2 = nums[1];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) right--;
            if (nums[left] + nums[right] < target) left++;
            if (nums[left] + nums[right] == target) {
                res1 = nums[left];
                res2 = nums[right];
                break;
            }
        }
        return new int[]{res1, res2};
    }
    //大佬的简洁写法
    /*public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }*/
}
