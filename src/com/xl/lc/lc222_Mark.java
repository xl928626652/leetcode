package com.xl.lc;

/**
 * @ClassName : lc222
 * @Author : Xulian
 * @Date : 2020/11/24 14:40
 */
public class lc222_Mark {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        TreeNode tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
            level++;
        }
        int left = 1 << level, right = (1 << (level + 1)) - 1;
        while (left != right) {
            int mid = left + (right - left + 1) / 2;
            if (exist(root, mid, level)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean exist(TreeNode root, int mid, int level) {
        int bit = 1 << level - 1;
        while (root != null && bit != 0) {
            if ((bit & mid) == 0) {
                root = root.left;
            } else {
                root = root.right;
            }
            bit >>= 1;
        }
        return root != null;
    }

    public static void main(String[] args) {
        int a = 1 << 1 - 1;

    }
}
