package com.xl.lc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc968H {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==1){
            result++;
        }
        return result;
    }
    //0:可被观测但无监控，上一层节点为1
    //1：不可被观测到，上一层节点为2
    //2：有摄像机，上一层节点为0
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftStatus = dfs(root.left),rightStatus = dfs(root.right);
        if(leftStatus==1||rightStatus==1){
            result++;
            return 2;
        }else if(leftStatus==2||rightStatus==2){
            return 0;
        }else{
            return 1;
        }
    }
//    public int minCameraCover(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Deque<TreeNode> deque = new LinkedList<>();
//        int count = 0;
//        Deque<Integer> camera = new LinkedList<>();
//        if(root.left!=null) {
//            deque.push(root.left);
//            camera.push(0);
//        }
//        if(root.right!=null){
//            deque.push(root.right);
//            camera.push(0);
//        }
//        while (!deque.isEmpty()) {
//            TreeNode treeNode;
//            int flag=0;
//            for (int i = 0; i < deque.size(); i++) {
//                 treeNode = deque.poll();
//                 flag = camera.poll();
//                 if(flag == 0) count++;
//                 if(treeNode.left!=null){
//                     deque.push(treeNode.left);
//                     if(flag == 0){
//                         camera.push(1);
//                     }else{
//                         camera.push(0);
//                     }
//                 }
//                if(treeNode.right!=null){
//                    deque.push(treeNode.right);
//                    if(flag == 0){
//                        camera.push(1);
//                    }else{
//                        camera.push(0);
//                    }
//                }
//            }
//        }
//        return count;
//    }
}
