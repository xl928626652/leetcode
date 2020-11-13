package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class jz_57_2_Mark {
    public int[][] findContinuousSequence(int target) {

        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        //list转Array
        return  res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

    }
}
