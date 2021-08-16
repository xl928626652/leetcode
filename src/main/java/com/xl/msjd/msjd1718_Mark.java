package com.xl.msjd;

import java.util.*;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1718_Mark {
    //滑动窗口
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> needs = new HashSet<>();
        Map<Integer, Integer> window = new HashMap<>();
        for (int i : small) {
            needs.add(i);
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE, start = 0, match = 0;
        while (right < big.length) {
            int cur = big[right];
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (needs.contains(cur) && window.get(cur) == 1) {
                match++;
            }
            right++;
            while (match == small.length) {
                int remove = big[left];
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }
                if (window.get(remove) == 1 && needs.contains(remove)) {
                    match--;
                }
                window.put(remove, window.get(remove) - 1);
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? new int[0] : new int[]{start, start + min - 1};
    }
}
