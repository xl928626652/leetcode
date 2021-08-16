package com.xl.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : lc5624
 * @Author : Xulian
 * @Date : 2020/12/27 13:41
 */
public class lc5624 {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        int temp = 0, min = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) ls.add(i);
        }
        int mid = k / 2;
        int tk = k;
        for (int i = 1; i < ls.size(); i++) {
            if (tk > 1) {
                int dis = tk > mid ? k - tk + 1 : tk - 1;
                temp += (ls.get(i) - ls.get(i - 1) - 1) * (Math.min(dis, mid));
                tk--;
            } else {
                min = Math.min(min, temp);
                temp -= k % 2 == 0 ? ls.get(i - mid) - ls.get(i - k) : ls.get(i - mid - 1) - ls.get(i - k);
                temp += ls.get(i) - ls.get(i - mid);
            }
        }
        min = Math.min(min, temp);
        return min;
    }
}
