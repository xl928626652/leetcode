package com.xl.msjd;

import com.xl.base.MGraph;
import com.xl.base.ALGraph;
public class msjd0401 {
    //邻接矩阵 超时
//    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
//        MGraph mGraph = new MGraph(n, graph.length);
//        for (int i = 0; i < n; i++) {
//            mGraph.vertices[i] = i;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    mGraph.adjMatrix[i][j] = 0;
//                } else {
//                    mGraph.adjMatrix[i][j] = -1;
//                }
//            }
//        }
//        for (int[] a : graph){
//            mGraph.adjMatrix[a[0]][a[1]]=1;
//        }
//        mGraph.BFS(start);
//        return false;
//    }
    //邻接链表，BFS也差点超时
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if(n==0) return false;
        ALGraph alGraph = new ALGraph(n,graph.length);
        for (int i = 0; i < alGraph.vertices_num; i++) {
            alGraph.vertices[i] = new ALGraph.VertexNode(i);
        }
        int[][] edges = new int[alGraph.edge_num][2];
        for (int i = 0; i < alGraph.edge_num; i++) {
            int vertex1 = graph[i][0];
            int vertex2 = graph[i][1];
            ALGraph.EdgeNode edgeNode = new ALGraph.EdgeNode(vertex2);
            edgeNode.setNext(alGraph.vertices[vertex1].getFirst());
            alGraph.vertices[vertex1].setFirst(edgeNode);
        }
        //这里改写一下BFS return boolean 就行
        //alGraph.BFS(start,target);
        return false;
    }
}
