package com.xl.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName : BIT
 * @Author : Xulian
 * @Date : 2020/11/10 21:58
 */
public class BIT {
    public int n;
    public int[] tree;

    public BIT(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void update(int i, int val) {
        while (i <= n) {
            tree[i] += val;
            i += lowbit(i);
        }
    }

    public int getSum(int i) {
        int res = 0;
        while (i > 0) {
            res += tree[i];
            i -= lowbit(i);
        }
        return res;
    }

    public int lowbit(int x) {
        return x & (-x);
    }

}
//    public int reversePairs(int[] nums) {
//        Set<Long> allNumbers = new TreeSet<Long>();
//        for (int x : nums) {
//            allNumbers.add((long) x);
//            allNumbers.add((long) x * 2);
//        }
//
//        // 利用哈希表进行离散化
//        Map<Long, Integer> values = new HashMap<Long, Integer>();
//        int idx = 1;
//        for (long x : allNumbers) {
//            System.out.println(x);
//            values.put(x, idx);
//            idx++;
//        }
//
//        int ret = 0;
//        BIT bit = new BIT(values.size());
//        for (int i = 0; i < nums.length; i++) {
//            int left = values.get((long) nums[i] * 2);
//            ret += bit.getSum(values.size()) - bit.getSum(left);
//            bit.update(values.get((long) nums[i]), 1);
//        }
//        return ret;
//    }

//    作者：zanyjoker
//    链接：https://leetcode-cn.com/problems/create-sorted-array-through-instructions/solution/java-frenwick-tree-shuang-bai-by-zanyjoker/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


