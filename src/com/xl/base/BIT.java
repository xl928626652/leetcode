package com.xl.base;

/**
 * @ClassName : BIT
 * @Author : Xulian
 * @Date : 2020/11/10 21:58
 */
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
