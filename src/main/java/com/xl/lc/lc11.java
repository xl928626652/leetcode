package com.xl.lc;

public class lc11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int a = height[left];
            int b = height[right];
            int smaller = Math.min(a, b);
            max = Math.max((right - left) * smaller, max);
            if (smaller == a) {
                while (left < right && height[left] <= a) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= b) {
                    right--;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new lc11().maxArea(height));
    }
}
