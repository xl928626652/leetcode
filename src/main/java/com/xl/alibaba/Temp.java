package com.xl.alibaba;

import com.xl.base.BIT;
import com.xl.lc.lc1649_BIT_SegTree;

import java.io.*;
import java.util.*;

/**
 * @ClassName : Temp
 * @Author : Xulian
 * @Date : 2021/3/11 16:39
 */
public class Temp {
    static Map<Integer, List<Integer>> g;
    static int n, k;
    static int[] lev;
    static boolean[] vis;
    static Deque<Integer> stk;
    static long ans;
    static int MOD = (int) 1e9 + 7;
    static int max = (int) -2e9, min = (int) 2e9;
    static boolean[] visT;

    public static int dfs(int node, int premax, int premin, boolean flag) {
        if (visT[node] || vis[node]) return 0;
        visT[node] = true;
        int level = lev[node];
        int tmax = Math.max(premax, level);
        int tmin = Math.min(premin, level);
        int resres = 0;
        if (tmax - tmin <= k) {
            if (flag) ans++;
        } else {
            return 0;
        }
        long t = 1;
        boolean flagt = false;
        List<Integer> list = g.getOrDefault(node, new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            int subres = dfs(x, tmax, tmin, false);
            if (flag) {
                t *= (subres == 0 ? 1 : subres);
                if (subres > 0) flagt = true;
            }
            resres += subres;
        }
        if (flag && flagt) ans += t;
        return resres + 1;

    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(br.readLine());
//        BIT bit = new BIT(n);
//        String[] temp = br.readLine().split(" ");
//        int[] weight = new int[temp.length];
//        int sum = 0;
//        for(int i = 0; i < weight.length; i++){
//            weight[i] = Integer.parseInt(temp[i]);
//            bit.update(i + 1, weight[i]);
//            sum += weight[i];
//        }
//        int[] order = new int[n];
//        temp = br.readLine().split(" ");
//        for(int i = 0; i < n; i++){
//            order[i] = Integer.parseInt(temp[i]);
//        }
////        System.out.println(Arrays.toString(bit.tree));
//
//
//        for(int i = 0; i < n; i++){
//            int x = order[i];
//            bit.update(x, -weight[x - 1]);
////            sum -= weight[x - 1];
//            int left = bit.getSum(x), right = bit.getSum(n) - left;
//            int ans = Math.max(left, right);
//            bw.write(ans+ "\n");
//        }
//        bw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        g = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]), b = Integer.parseInt(temp[1]);
            List<Integer> lista = g.getOrDefault(a, new ArrayList<>());
            List<Integer> listb = g.getOrDefault(b, new ArrayList<>());
            lista.add(b);
            listb.add(a);
            g.put(a, lista);
            g.put(b, listb);
        }
        temp = br.readLine().split(" ");
//        System.out.println(Arrays.toString(temp));
        lev = new int[n + 1];
        for (int i = 0; i < n; i++) {
            lev[i + 1] = Integer.parseInt(temp[i]);
        }
        vis = new boolean[n + 1];
        stk = new LinkedList<>();
        ans = 0;
        for (int i = 1; i <= n; i++) {
            visT = new boolean[n + 1];
            dfs(i, max, min, true);
            vis[i] = true;
            System.out.println(ans);
        }
        int res = (int) (ans % MOD);
        bw.write(res + "\n");
        bw.flush();

    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(br.readLine());
//        Map<Integer, Map<Integer, Integer>> g = new HashMap<>(n);
//        for (int row = 1; row < n; row++) {
//            String[] temp = br.readLine().split(" ");
//            Map<Integer, Integer> ma = g.getOrDefault(Integer.parseInt(temp[0]), new HashMap<>());
//            Map<Integer, Integer> mb = g.getOrDefault(Integer.parseInt(temp[1]), new HashMap<>());
//            ma.put(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
//            mb.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[2]));
//            g.put(Integer.parseInt(temp[0]), ma);
//            g.put(Integer.parseInt(temp[1]), mb);
//        }
//        Queue<int[]> q = new PriorityQueue<>();
//        int[] dist = new int[n + 1];
//        boolean[] vis = new boolean[n + 1];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[1] = 0;
//        q.add(new int[]{1, 0});
//        while (!q.isEmpty()) {
//            int[] e = q.poll();
//            int node = e[0];
//            if (vis[node]) continue;
//            vis[node] = true;
//            for (Map.Entry<Integer, Integer> entry : g.getOrDefault(node, new HashMap<>()).entrySet()) {
//                int key = entry.getKey(), value = entry.getValue();
//                if(dist[key] <= dist[node] + value){
//                    continue;
//                }else{
//                    dist[key] = dist[node] + value;
//                    q.add(new int[]{key, dist[key]});
//                }
//            }
//        }
//
//
//    }


}
