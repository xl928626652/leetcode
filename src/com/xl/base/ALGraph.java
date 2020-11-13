package com.xl.base;

import sun.security.provider.certpath.Vertex;

import java.util.LinkedList;
import java.util.Queue;


//写题的时候，把里面的类提出来，不要作为内部类
public class ALGraph {
    //暂时没用到，以后再说
    //对于一些测试用例，用邻接矩阵会爆内存。。

    public VertexNode[] vertices;
    public int vertices_num;
    public int edge_num;
    public boolean[] visited;

    public ALGraph(int n, int e) {
        if (n == 0) {
            return;
        }
        vertices_num = n;
        edge_num = e;
        vertices = new VertexNode[vertices_num];
        visited = new boolean[vertices_num];
    }

    public void initGraph() {
//        for (int i = 0; i < vertices_num; i++) {
//            vertices[i] = new VertexNode(i);
//        }
//        for (int i = 0; i < edge_num; i++) {
//            int vertex1 = ;
//            int vertex2 = ;
//            EdgeNode edgeNode = new EdgeNode(vertex2);
//            edgeNode.setNext(vertices[vertex1].getFirst());
//            vertices[vertex1].setFirst(edgeNode);
//        }
    }

    public void DFS(int startIndex) {
        VertexNode vertexNode = vertices[startIndex];
        visited[startIndex] = true;
        System.out.println(startIndex);
        EdgeNode p = vertexNode.getFirst();
        while (p != null) {
            int vertexIndex = p.getAdjvex();

            if (!visited[vertexIndex]) {
                DFS(vertexIndex);
            }
            p = p.getNext();
        }
    }

    public void BFS(int startIndex) {
        VertexNode vertexNode = vertices[startIndex];
        visited = new boolean[vertices_num];
        Queue<Integer> queue = new LinkedList<>();
        visited[startIndex] = true;
        queue.add(startIndex);
//        打印startIndex
        System.out.println(startIndex);
        while (!queue.isEmpty()) {
            int index = queue.remove();

            VertexNode node = vertices[index];
            EdgeNode p = node.getFirst();
            while (p != null) {
                int vertexIndex = p.getAdjvex();
                if (!visited[vertexIndex]) {
                    //打印遍历的节点
                    System.out.println(vertexIndex);
                    visited[vertexIndex] = true;
                    queue.add(vertexIndex);
                }
                p = p.getNext();
            }
        }
    }

    public static class VertexNode {
        private int vertex;
        private EdgeNode first;

        public VertexNode() {
            vertex = -1;
            first = null;
        }

        public VertexNode(int vertex) {
            this.vertex = vertex;
            first = null;
        }

        public EdgeNode getFirst() {
            return first;
        }

        public int getVertex() {
            return vertex;
        }

        public void setFirst(EdgeNode first) {
            this.first = first;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }
    }

    public static class EdgeNode {
        private int adjvex;
        private EdgeNode next;

        public EdgeNode(int adjvex) {
            this.adjvex = adjvex;
        }

        public EdgeNode getNext() {
            return next;
        }

        public int getAdjvex() {
            return adjvex;
        }

        public void setAdjvex(int adjvex) {
            this.adjvex = adjvex;
        }

        public void setNext(EdgeNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //测试DFS
       /* ALGraph alGraph = new ALGraph(7, 11);
        for (int i = 0; i < alGraph.vertices_num; i++) {
            alGraph.vertices[i] = new VertexNode(i);
        }
        int[][] edges = new int[alGraph.edge_num][2];
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[1][0] = 0;
        edges[1][1] = 2;
        edges[2][0] = 2;
        edges[2][1] = 1;
        edges[3][0] = 1;
        edges[3][1] = 3;
        edges[4][0] = 2;
        edges[4][1] = 4;
        edges[5][0] = 3;
        edges[5][1] = 4;
        edges[6][0] = 5;
        edges[6][1] = 3;
        edges[7][0] = 3;
        edges[7][1] = 6;
        edges[8][0] = 4;
        edges[8][1] = 5;
        edges[9][0] = 4;
        edges[9][1] = 6;
        edges[10][0] = 6;
        edges[10][1] = 5;
        for (int i = 0; i < alGraph.edge_num; i++) {
            int vertex1 = edges[i][0];
            int vertex2 = edges[i][1];
            EdgeNode edgeNode = new EdgeNode(vertex2);
            edgeNode.setNext(alGraph.vertices[vertex1].getFirst());
            alGraph.vertices[vertex1].setFirst(edgeNode);
        }
        alGraph.DFS(0);*/

        //测试BFS
        /*ALGraph alGraph = new ALGraph(7, 11);
        for (int i = 0; i < alGraph.vertices_num; i++) {
            alGraph.vertices[i] = new VertexNode(i);
        }
        int[][] edges = new int[alGraph.edge_num][2];
        edges[0][0] = 0;
        edges[0][1] = 1;
        edges[1][0] = 0;
        edges[1][1] = 2;
        edges[2][0] = 2;
        edges[2][1] = 1;
        edges[3][0] = 1;
        edges[3][1] = 3;
        edges[4][0] = 2;
        edges[4][1] = 4;
        edges[5][0] = 3;
        edges[5][1] = 4;
        edges[6][0] = 5;
        edges[6][1] = 3;
        edges[7][0] = 3;
        edges[7][1] = 6;
        edges[8][0] = 4;
        edges[8][1] = 5;
        edges[9][0] = 4;
        edges[9][1] = 6;
        edges[10][0] = 6;
        edges[10][1] = 5;
        for (int i = 0; i < alGraph.edge_num; i++) {
            int vertex1 = edges[i][0];
            int vertex2 = edges[i][1];
            EdgeNode edgeNode = new EdgeNode(vertex2);
            edgeNode.setNext(alGraph.vertices[vertex1].getFirst());
            alGraph.vertices[vertex1].setFirst(edgeNode);
        }
        alGraph.BFS(0);*/

    }
}
