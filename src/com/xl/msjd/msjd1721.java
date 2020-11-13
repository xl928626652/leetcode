package com.xl.msjd;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1721 {
    //滑动窗口
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int sum = 0, index = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                sum += leftMax - height[left++];
                leftMax = Math.max(leftMax, height[left]);
            } else {
                sum += rightMax - height[right--];
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return sum;
    }
}
