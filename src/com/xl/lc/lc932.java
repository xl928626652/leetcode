package com.xl.lc;

/**
 * @ClassName : lc932
 * @Author : Xulian
 * @Date : 2020/10/18 20:54
 */
public class lc932 {
    public int[] beautifulArray(int N) {
        int[] res = new int[N];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        int left = 0, right = res.length - 1;
        while (left < right) {
            if (((res[left] + res[right]) & 1) != 0) {
                right--;
            } else {
                int count = 0;
                for (int i = left+1; i < right; i++) {
                    if(2*res[i]==res[left]+res[right]){
                        swap(res,i,right);
                        count=1;
                        break;
                    }
                }
                if(count==0){
                    left++;
                }
            }

        }
        return res;
    }
    public void swap(int[] nums,int a, int b){
        nums[a]=nums[a] ^ nums[b];
        nums[b]=nums[a] ^ nums[b];
        nums[a]=nums[a] ^ nums[b];
    }
}
