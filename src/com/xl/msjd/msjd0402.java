package com.xl.msjd;

public class msjd0402 {
    int[] ints;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        ints = nums;
        TreeNode root = new TreeNode(ints[nums.length / 2]);
        root.left = recur(0, nums.length / 2 - 1);
        root.right = recur(nums.length / 2 + 1, nums.length - 1);
        return root;
    }

    public TreeNode recur(int left, int right) {
        if (left > right) return null;
        TreeNode root = new TreeNode(ints[(left + right) / 2]);
        root.left = recur(left, (left + right) / 2 - 1);
        root.right = recur((left + right) / 2 + 1, right);
        return root;
    }
}
