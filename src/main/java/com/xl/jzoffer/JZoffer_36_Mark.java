package com.xl.jzoffer;

public class JZoffer_36_Mark {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    //树递归+需要改动树中的指针指向，就在对象的属性中定义辅助的Node，
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void recur(Node root){
        if(root == null) return;
        recur(root.left);
        if(pre==null){
            head=root;
        }else{
            pre.right=root;
        }
        root.left=pre;
        pre=root;
        recur(root.right);
    }
}
