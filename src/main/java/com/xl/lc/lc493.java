package com.xl.lc;

import com.xl.base.BIT;

import java.util.*;

/**
 * @ClassName : lc493
 * @Author : Xulian
 * @Date : 2020/11/28 20:51
 */
public class lc493 {
    public int reversePairs(int[] nums) {
        Set<Long> allNumbers = new TreeSet<Long>();
        for (int x : nums) {
            allNumbers.add((long) x);
            allNumbers.add((long) x * 2);
        }

        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 1;
        for (long x : allNumbers) {
            System.out.println(x);
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BIT bit = new BIT(values.size());
        for (int i = 0; i < nums.length; i++) {
            int left = values.get((long) nums[i] * 2);
            ret += bit.getSum(values.size()) - bit.getSum(left);
            bit.update(values.get((long) nums[i]), 1);
        }
        return ret;
    }

}
