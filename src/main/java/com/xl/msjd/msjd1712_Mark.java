package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1712_Mark {
    TreeNode head = new TreeNode(-1);   // 为了返回单向链表的头节点而多设的一个节点
    TreeNode pre = null;               // 指向当前节点的前一个节点

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre == null) {     // 第一个节点
            pre = root;        // 记录第一个节点
            head.right = root;  // 记录它，它将作为单链表的表头
        } else {                // 第一个节点之后的节点
            pre.right = root;  // 前一个节点的右指针指向当前节点
            pre = root;        // 更新perv指向
        }
        root.left = null;       // 当前节点的左指针设为null
        helper(root.right);
    }
}
