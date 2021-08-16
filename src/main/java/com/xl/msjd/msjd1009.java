package com.xl.msjd;

/**
 * @ClassName : msjd1005
 * @Author : Xulian
 * @Date : 2020/10/4 18:43
 */
public class msjd1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i = 0, j = matrix[0].length - 1;
        while(i>=0 && i<=matrix.length - 1 && j>=0 && j<= matrix[0].length - 1){
            if(target > matrix[i][j]){
                i++;
            }else if(target < matrix[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}
