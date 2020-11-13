package com.xl.lc;

/**
 * @ClassName : lc922
 * @Author : Xulian
 * @Date : 2020/11/12 17:02
 */
public class lc922 {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1, even = 0, n = A.length;
        while(odd < n && even < n){
            while(odd < n && ((A[odd] & 1) == 1)){
                odd += 2;
            }
            while(even < n && ((A[even] & 1) == 0)){
                even += 2;
            }
            if (odd < n && even < n){
                swap(A, odd, even);
            }
        }
        return A;
    }
    public void swap(int[] nums, int a, int b){
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
