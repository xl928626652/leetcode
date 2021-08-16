package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc1649
 * @Author : Xulian
 * @Date : 2020/11/10 22:58
 */
public class lc1649_BIT_SegTree {
    public class BIT {
        int n;
        int[] tree;

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

//    作者：zanyjoker
//    链接：https://leetcode-cn.com/problems/create-sorted-array-through-instructions/solution/java-frenwick-tree-shuang-bai-by-zanyjoker/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public int createSortedArray(int[] instructions) {
        int mod = (int) 1e9 + 7;
        long ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < instructions.length; ++i) {
            set.add(instructions[i]);
        }
        int[] nums = new int[set.size()];
        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i + 1);
        }

        BIT bit = new BIT(nums.length);

        for (int i = 0; i < instructions.length; ++i) {

            int t = map.get(instructions[i]);
            int l = bit.getSum(t - 1);
            int r = bit.getSum(t);

            ans += Math.min(l, i - r);
            ans %= mod;
            bit.update(t, 1);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] ins = new int[]{1,5,6,2};
        new lc1649_BIT_SegTree().createSortedArray(ins);
    }

}
