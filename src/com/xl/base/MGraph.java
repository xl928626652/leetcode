package com.xl.base;

import java.util.Deque;
import java.util.LinkedList;

public class MGraph {
    public int v_num;//节点数
    public int e_num;//边数
    public int[] vertices;//节点数组
    public int[][] adjMatrix;//邻接矩阵
    boolean[] visited;//标志数组

    public MGraph(int v_num, int e_num) {
        this.v_num = v_num;
        this.e_num = e_num;
        vertices = new int[v_num];
        adjMatrix = new int[v_num][v_num];
        visited = new boolean[v_num];
    }

    public void initDijkGraph() { //Dijk
        for (int i = 0; i < v_num; i++) {
            vertices[i] = i;
        }
        for (int i = 0; i < v_num; i++) {
            for (int j = 0; j < v_num; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = -1;
                }
            }
        }
        adjMatrix[0][1] = 10;
        adjMatrix[1][2] = 50;
        adjMatrix[0][4] = 100;
        adjMatrix[0][3] = 30;
        adjMatrix[2][4] = 10;
        adjMatrix[3][4] = 60;
        adjMatrix[3][2] = 20;

        //这里写生成graph的边
    }
    public void initFloidGraph() { //Floid
        for (int i = 0; i < v_num; i++) {
            vertices[i] = i;
        }
        for (int i = 0; i < v_num; i++) {
            for (int j = 0; j < v_num; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = -1;
                }
            }
        }
        adjMatrix[0][1] = 10;
        adjMatrix[1][2] = 50;
        adjMatrix[0][4] = 100;
        adjMatrix[0][3] = 30;
        adjMatrix[2][4] = 10;
        adjMatrix[3][4] = 60;
        adjMatrix[3][2] = 20;

        //这里写生成graph的边
    }

    //lc1584自己初始化邻接矩阵
    public void initGraph() { //Prim & BFS & DFS
        for (int i = 0; i < v_num; i++) {
            vertices[i] = i;
        }
        for (int i = 0; i < v_num; i++) {
            for (int j = 0; j < v_num; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = -1;
                }
            }
        }
        adjMatrix[0][1] = 34;
        adjMatrix[1][0] = 34;
        adjMatrix[0][2] = 46;
        adjMatrix[2][0] = 46;
        adjMatrix[0][5] = 19;
        adjMatrix[5][0] = 19;
        adjMatrix[1][4] = 12;
        adjMatrix[4][1] = 12;
        adjMatrix[4][5] = 26;
        adjMatrix[5][4] = 26;
        adjMatrix[2][5] = 25;
        adjMatrix[5][2] = 25;
        adjMatrix[2][3] = 17;
        adjMatrix[3][2] = 17;
        adjMatrix[3][5] = 25;
        adjMatrix[5][3] = 25;
        adjMatrix[3][4] = 38;
        adjMatrix[4][3] = 38;
        //这里写生成graph的边
    }

    public void DFS(int startIndex) {
        visited[startIndex] = true;
        for (int i = 0; i < v_num; i++) {
            if (adjMatrix[startIndex][i] > 0 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public void BFS(int startIndex) {
        visited[startIndex] = true;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(startIndex);
        int front;
        while (!deque.isEmpty()) {
            front = deque.removeFirst();
            System.out.println(front);
            for (int i = 0; i < v_num; i++) {
                if (adjMatrix[front][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    deque.add(i);
                }
            }
        }
    }

    public int getMin(int[] lowcost) {
        int min = 0, index = -1;
        for (int i = 0; i < lowcost.length; i++) {
            if (lowcost[i] > 0) {
                min = lowcost[i];
                index = i;
                break;
            }
        }
        for (int i = 0; i < lowcost.length; i++) {
            if (lowcost[i] < min && lowcost[i] > 0) {
                index = i;
                min = lowcost[i];
            }
        }
        return index;
    }

    public int Prim(int startIndex) {
        int sum = 0;
        int[] adjvex = new int[v_num];
        int lowcost[] = new int[v_num];
        for (int i = 0; i < v_num; i++) {
            lowcost[i] = adjMatrix[startIndex][i];
            adjvex[i] = startIndex;
        }
        for (int i = 1; i < v_num; i++) {
            int minIndex = getMin(lowcost);
            sum += lowcost[minIndex];
//            System.out.println(lowcost[minIndex]);
            lowcost[minIndex] = 0;
            for (int j = 0; j < v_num; j++) {
                if (adjMatrix[j][minIndex] != -1 && (lowcost[j] == -1 || adjMatrix[j][minIndex] < lowcost[j])) {
                    lowcost[j] = adjMatrix[j][minIndex];
                    adjvex[j] = minIndex;
                }
            }
        }
        return sum;
    }

    public String[] Dijkstra(int startIndex) {
        int[] dist = new int[v_num];
        String[] path = new String[v_num];
        int minEdge;
        for (int i = 0; i < v_num; i++) {
            dist[i] = adjMatrix[startIndex][i];
            if (dist[i] != -1) {
                path[i] = vertices[startIndex] + " " + vertices[i];
            } else {
                path[i] = "";
            }
        }
        for (int num = 1; num < v_num; num++) {
            minEdge = getMin(dist);
            if (minEdge == -1) {
                break;//代表已经找不到可以到达的节点了
            }
            for (int i = 0; i < v_num; i++) {
                if (adjMatrix[minEdge][i] != -1 && (dist[i] == -1 || dist[i] > dist[minEdge] + adjMatrix[minEdge][i])) {
                    dist[i] = dist[minEdge] + adjMatrix[minEdge][i];
                    path[i] = path[minEdge] + " " + vertices[i];
                }
            }
            dist[minEdge] = 0;
        }
        return path;
    }
    public int[][] floid(){
        int[][] dist = new int[v_num][v_num];
        String[][] path = new String[v_num][v_num];
        for (int i = 0; i < v_num; i++) {
            for (int j = 0; j < v_num; j++) {
                dist[i][j]=adjMatrix[i][j];
                if(dist[i][j]!=-1 && dist[i][j]!=0){
                    path[i][j] = vertices[i] + " "+vertices[j];
                }else {
                    path[i][j] = "";
                }
            }
        }
        for (int k = 0; k < v_num; k++) {
            for (int i = 0; i < v_num; i++) {
                for (int j = 0; j < v_num; j++) {
                    if ((dist[i][k] != -1 && dist[k][j] !=-1) && (dist[i][j]==-1 || dist[i][k]+ dist[k][j]< dist[i][j])){
                        dist[i][j]= dist[i][k]+ dist[k][j];
                        path[i][j]=path[i][k]+vertices[j];
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args8) {
//        MGraph mGraphPrim = new MGraph(6, 9);
//        mGraphPrim.initGraph();
////        mGraph.BFS(0);
//        int minWeight = mGraphPrim.Prim(0);

//        MGraph mGraphDijk = new MGraph(5, 7);
//        mGraphDijk.initDijkGraph();
//        int startIndex = 1, end = 2;
//        String[] path = mGraphDijk.Dijkstra(startIndex);
//        if (path[end].equals("")) System.out.println("没有可以通过的路径");
//        String[] nodes = path[end].split(" ");
//        int sum = 0;
//        for (int i = 0; i < nodes.length - 1; i++) {
//            sum += mGraphDijk.adjMatrix[Integer.parseInt(nodes[i])][Integer.parseInt(nodes[i + 1])];
//        }
//        System.out.println(sum);
        MGraph mGraphFloid = new MGraph(5,7);
        mGraphFloid.initFloidGraph();
        int[][] res =mGraphFloid.floid();
        for (int[] ints : res){
            for (int i : ints){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
