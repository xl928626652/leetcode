package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc321
 * @Author : Xulian
 * @Date : 2020/11/22 17:24
 */
public class lc321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<String> max = new ArrayList<>();
        for (int subLength1 = 0; subLength1 <= k && subLength1 <= n1; subLength1++) {
            int subLength2 = k - subLength1;
            if (subLength2 > nums2.length) continue;
            int[] res1 = maxSubNumber(nums1, subLength1);
            int[] res2 = maxSubNumber(nums2, subLength2);
            int[] mergedRes = merge(res1, res2);
            StringBuilder sb = new StringBuilder();
            for (int i : mergedRes) {
                sb.append(i);
            }
            max.add(sb.toString());
        }
        Collections.sort(max, Comparator.reverseOrder());
        String s = max.get(0);
        int[] res = new int[s.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.charAt(i) - '0';
        }
        return res;
    }

    public int[] maxSubNumber(int[] nums, int k) {
        int[] res = new int[k];
        if (k == 0) return res;
        k = nums.length - k;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) deque.offerLast(nums[i]);
            else {
                while (!deque.isEmpty() && k > 0 && deque.peekLast() < nums[i]) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(nums[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = deque.pollLast();
        }
        return res;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) { // 不能只比较当前值，如果当前值相等还需要比较后续哪个大
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }

    public boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{6, 7};
        int[] nums2 = new int[]{6, 0, 4};
        int[] res = new lc321().maxNumber(nums1, nums2, 5);
        System.out.println(Arrays.toString(res));
    }
}
