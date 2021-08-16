package com.xl.lc;

/**
 * @ClassName : lc941
 * @Author : Xulian
 * @Date : 2020/11/3 16:31
 */
public class lc941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int index = 1;
        while (index < A.length && A[index]>=A[index - 1]){
            if (A[index] == A[index - 1]){
                return false;
            }
            index++;
        }
        if (index == A.length || index == 1) return false;

        while (index < A.length && A[index]<=A[index - 1]){
            if (A[index] == A[index - 1]){
                return false;
            }
            index++;
        }
        return index == A.  length;
    }
}
