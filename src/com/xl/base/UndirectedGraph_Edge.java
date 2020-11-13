package com.xl.base;

import java.util.*;

//需要改
public class UndirectedGraph_Edge {
    static class Edge {
        private int begin;
        private int end;
        private int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }
    private Edge[] edges; // 边数组
    private int edgeSize; // 边的数量
    private int numSize;
    public UndirectedGraph_Edge(int edgeSize,int numSize) {
        this.edgeSize = edgeSize;
        this.edges = new Edge[edgeSize];
        this.numSize = numSize;
    }

    // 生成边数组
    public void createEdges() {
//        edges[0] = new Edge(4, 7, 7);
//        edges[1] = new Edge(2, 8, 8);
//        edges[2] = new Edge(0, 1, 10);
//        edges[3] = new Edge(0, 5, 11);
//        edges[4] = new Edge(1, 8, 12);
//        edges[5] = new Edge(3, 7, 16);
//        edges[6] = new Edge(1, 6, 16);
//        edges[7] = new Edge(5, 6, 17);
//        edges[8] = new Edge(1, 2, 18);
//        edges[9] = new Edge(6, 7, 19);
//        edges[10] = new Edge(3, 4, 20);
//        edges[11] = new Edge(3, 8, 21);
//        edges[12] = new Edge(2, 3, 22);
//        edges[13] = new Edge(3, 6, 24);
//        edges[14] = new Edge(4, 5, 26);
        edges[0] = new Edge(0,1,1);
        edges[1] = new Edge(0,2,2);
        edges[2] = new Edge(1,4,3);
        edges[3] = new Edge(2,3,4);
    }

    // 克鲁斯卡尔算法 使用前需要把边按照长度从小到大排序，k是最大边的长度
    public int Kruskal(int k) {
        int[] fromTo = new int[numSize];
        Arrays.fill(fromTo, -1);
        int sum = 0;
        for (int i = 0; i < edgeSize; i++) {// 从权重最小的边开始,如果没有形成回环,则该边是满足条件的边
            int n = find(fromTo, edges[i].begin);
            int m = find(fromTo, edges[i].end);
            if (n != m) {
                fromTo[n] = m;
                sum += edges[i].weight;
            }//如果n==m，说明两个节点在一个连通分量中，会组成回环
        }
        return sum;
    }
    private int find(int[] p, int f) {
        while (p[f] > -1) {
            f = p[f];
        }
        return f;
    }
    public static void main(String[] args) {
        UndirectedGraph_Edge undirectedGraphEdge = new UndirectedGraph_Edge(4,5);
        undirectedGraphEdge.createEdges();//这里的edges是排好序的，否则还要手动排序
        System.out.println(undirectedGraphEdge.Kruskal(2));


    }

//    public static void main(String[] args) {
//        //输入用例
//        /*
//        2
//        3 3 400 这一句话意思是 3个节点、3条边 最大的长度有限制
//        1 2 200
//        1 3 300
//        2 3 500
//        * */
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for (int i = 0; i < T; i++) {
//            int n=scanner.nextInt(), m=scanner.nextInt(), k=scanner.nextInt();
//            Kruskal graph = new Kruskal(m);
//            for (int j = 0; j < m; j++) {
//                graph.edges[j] = new Edge(scanner.nextInt()-1,scanner.nextInt()-1,scanner.nextInt());
//            }
//            Arrays.sort(graph.edges, Comparator.comparingInt(o -> o.weight));
//            graph.Kruskal(k);
//            if(graph.count<n-1){
//                System.out.println("No");
//            }else{
//                System.out.println("Yes");
//            }
//        }
//    }
}