package com.xl.base;

import java.util.*;

/**
 * @ClassName : Dijkstra_Heap
 * @Author : Xulian
 * @Date : 2021/3/11 11:53
 */
public class Dijkstra_Heap {
    //这里是默认从n点的单源最短路 堆优化
    public void dijkstra_heap(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0], end = edge[1], weight = edge[2];
            Map<Integer, Integer> mapa = graph.getOrDefault(start, new HashMap<>());
            Map<Integer, Integer> mapb = graph.getOrDefault(end, new HashMap<>());
            mapa.put(end, weight);
            mapb.put(start, weight);
            graph.put(start, mapa);
            graph.put(end, mapb);
        }
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        int[] dist = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int p = e[0];
            if (vis[p]) continue;
            vis[p] = true;
            Map<Integer, Integer> map = graph.get(p);
            for (int i : map.keySet()) {
                int weight = map.get(i);
                if (dist[i] <= dist[p] + weight) continue;
                else dist[i] = dist[p] + weight;
                q.add(new int[]{i, dist[i]});
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}};
        int n = 5;
        new Dijkstra_Heap().dijkstra_heap(n, edges);
    }
}
