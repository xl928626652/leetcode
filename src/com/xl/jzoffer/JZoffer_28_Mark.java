package com.xl.jzoffer;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JZoffer_28_Mark {

    //迭代
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root == null) return true;
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            List<TreeNode> list = new ArrayList<>();
//            TreeNode p;
//            for (int i = queue.size() - 1; i > -1; i--) {
//                p = queue.poll();
//                list.add(p);
//                if(p.val!=-10000){
//                    queue.add(p.left == null ? new TreeNode(-10000):p.left);
//                    queue.add(p.right == null ? new TreeNode(-10000):p.right);
//                }
//            }
//            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
//                if(list.get(i).val!=list.get(j).val){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    //这个方法比较合适，属于对本题以及树的递归很明白之后的做法。
    /*public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode l,TreeNode r){
        if(l == null && r == null) return true;
        if(l==null || r ==null || l.val!=r.val) return false;
        return recur(l.left,r.right) && recur(l.right,r.left);
    }*/

    //这个写法使用了27的方法。太暴力，不合适。
    TreeNode new_root = new TreeNode(0);

    public TreeNode mirrorTree(TreeNode root) {
        recur(root);
        return root;
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        //这个recur放在哪里都是一样的，这个挺重要的
        // recur(root.left);
        // recur(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recur(root.left);
        recur(root.right);
    }

    //主方法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        new_root.val = root.val;
        copyTree(new_root, root);
        new_root = mirrorTree(new_root);
        return isSame(new_root, root);
    }

    public boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null) return false;
        if (b == null) return false;
        if (a.val == b.val) return isSame(a.left, b.left) && isSame(a.right, b.right);
        return false;

    }

    public void copyTree(TreeNode new_root, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode root_left = new TreeNode(root.left.val);
            new_root.left = root_left;
        }
        if (root.right != null) {
            TreeNode root_right = new TreeNode(root.right.val);
            new_root.right = root_right;
        }
        copyTree(new_root.left, root.left);
        copyTree(new_root.right, root.right);
    }
}
