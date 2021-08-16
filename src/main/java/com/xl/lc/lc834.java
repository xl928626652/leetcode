package com.xl.lc;

import com.xl.base.MGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : lc834
 * @Author : Xulian
 * @Date : 2020/10/6 16:12
 */
public class lc834 {

    //    public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        MGraph mGraphFloid = new MGraph(N, N - 1);
//        mGraphFloid.initFloidGraph();
//        for (int[] ints : edges) {
//            mGraphFloid.adjMatrix[ints[0]][ints[1]] = 1;
//            mGraphFloid.adjMatrix[ints[1]][ints[0]] = 1;
//        }
//        int[][] dist = mGraphFloid.floid();
//        int[] res = new int[N];
//        for (int i = 0; i < N; i++) {
//            for (int num : dist[i]) {
//                res[i] += num;
//            }
//        }
//        return res;
//    }
    //Floid 超内存 时间复杂度O（n3） 如果是每个点都dfs一下，那么时间复杂度O（n2）
    //这个解法很巧妙 //https://leetcode-cn.com/problems/sum-of-distances-in-tree/solution/shou-hua-tu-jie-shu-zhong-ju-chi-zhi-he-shu-xing-d/ 评论中的一个java版本
    //主要掌握的是 树图的 邻接表表示法 用双重List表示
    private List<List<Integer>> graph = new ArrayList<>();//邻接表
    int[] distSum; //距离和
    int[] nodeNum; //子树节点个数（包括自己）

    public int[] sumOfDistancesInTree(int N, int[][] edges) {

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        distSum = new int[N];
        nodeNum = new int[N];
        Arrays.fill(nodeNum, 1);
        postOrder(0, -1);
        preOrder(0, -1);
        return distSum;
    }

    //求root到子树所有节点的距离和
    private void postOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for (Integer neighbor : neighbors) {
            if (neighbor == parent)
                continue; //如果邻接点是父节点，则跳过
            postOrder(neighbor, root);
            nodeNum[root] += nodeNum[neighbor];
            distSum[root] += distSum[neighbor] + nodeNum[neighbor];
        }
    }

    //根据root计算其邻居到所在子树之外的节点的距离和（包括root节点）
    private void preOrder(int root, int parent) {
        List<Integer> neighbors = graph.get(root);
        for (Integer neighbor : neighbors) {
            if (neighbor == parent)
                continue;
            distSum[neighbor] = distSum[root] - nodeNum[neighbor] + (graph.size() - nodeNum[neighbor]);
            preOrder(neighbor, root);
        }
    }
}
