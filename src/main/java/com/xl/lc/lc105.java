package com.xl.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : lc105
 * @Author : Xulian
 * @Date : 2021/2/24 16:14
 */
public class lc105 {
    //这道题必须是用inorder中左子树的个数来定位右子树的preOrder起始点，不能直接index + 1
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, n - 1, preorder, inorder);
    }

    public TreeNode recur(int start, int left, int right, int[] preorder, int[] inorder) {
        if (left > right) {
            return null;
        }
        int num = preorder[start];
        int index = map.get(num);
        int nums = index - left;
        TreeNode root = new TreeNode(num);
        root.left = recur(start + 1, left, index - 1, preorder, inorder);
        ;
        root.right = recur(start + 1 + nums, index + 1, right, preorder, inorder);
        ;
        return root;
    }

    public static void main(String[] args) {
        String s = new String("123");
        char b = 65;
        char d = '0';
        int c = 66;
        System.out.println('b' - 'a');
        System.out.println(b + ":" + (int) d + ":" + (char) c);
//        int[] preOrder = {1, 2, 3};
//        int[] inOrder = {2, 3, 1};
//        new lc105().buildTree(preOrder, inOrder);
    }
}
