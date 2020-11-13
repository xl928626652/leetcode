package com.xl.msjd;

public class msjd0803 {

    public int findMagicIndex(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(i== nums[i] && i<=res){
                res = i;
                break;
            }
        }
        if(res == nums.length) return -1;
        return res;
    }
}
