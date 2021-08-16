package com.xl.alibaba;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : Temp
 * @Author : Xulian
 * @Date : 2021/3/11 16:39
 */
public class TreeDp {
    static int[] weight;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] vis;
    static int[] max;
    static int[] min;
    static int[] childnum;
    static int maxDiff = -1;
    static int node = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        temp = br.readLine().trim().split(" ");
        weight = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(temp[i - 1]);
        }
        for (int i = 1; i < n; i++) {
            temp = br.readLine().trim().split(" ");
            int x = Integer.parseInt(temp[0]), y = Integer.parseInt(temp[1]);
            List<Integer> listx = graph.getOrDefault(x, new ArrayList<>());
            List<Integer> listy = graph.getOrDefault(y, new ArrayList<>());
            listx.add(y);
            listy.add(x);
            graph.put(x, listx);
            graph.put(y, listy);
        }
        int root = Integer.parseInt(br.readLine().trim());
        max = new int[n + 1];
        min = new int[n + 1];
        childnum = new int[n + 1];
        dfs(root, k);
        bw.write(node + "\n");
        bw.flush();
    }

    public static void dfs(int root, int k) {
        vis[root] = true;
        max[root] = weight[root];
        min[root] = weight[root];
        childnum[root] = 1;
        for (int i = 0; i < graph.get(root).size(); i++) {
            int child = graph.get(root).get(i);
            if (!vis[child]) {
                dfs(child, k);
                max[root] = Math.max(max[root], max[child]);
                min[root] = Math.min(min[root], min[child]);
                childnum[root] += childnum[child];
            }
        }
        if (childnum[root] <= k && max[root] - min[root] >= maxDiff) {
            if (maxDiff == -1) {
                maxDiff = max[root] - min[root];
                node = root;
            } else {
                if (max[root] - min[root] > maxDiff) {
                    maxDiff = max[root] - min[root];
                    node = root;
                } else {
                    node = Math.min(node, root);
                }
            }
        }
    }

}
