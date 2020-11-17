package com.xl.lc;

import java.util.*;

public class lc5552_Mark {
    //    int min;
//    boolean[] visited;
//    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        min = Integer.MAX_VALUE;
//        visited = new boolean[40001];
//        for(int i : forbidden){
//            visited[i] = true;
//        }
//        recur(forbidden, a, b, x, 1,0,0);
//        return min;
//    }
//    public void recur( int[] forbidden, int a, int b, int x, int flag, int curP, int curNum){
//        if (curP < 0){
//            return;
//        }
//        if (curP > 4005){
//            return;
//        }
//        if (visited[curP]) return;
//        if (curP == x){
//            min = Math.min(min, curNum + 1);
//        }
//        if (flag == -1){
//            visited[curP]=true;
//            recur(forbidden, a, b, x, 1,curP + a,curNum+1);
//            visited[curP]=false;
//        }else if (curP < x){
//            visited[curP] = true;
//            recur(forbidden, a, b, x, 1,curP + a,curNum+1);
//            visited[curP] = false;
//        }else if (curP > x ){
//            visited[curP] = true;
//            recur(forbidden, a, b, x, 1,curP + a,curNum+1);
//            recur(forbidden, a, b, x, -1,curP + a,curNum+1);
//            visited[curP] = false;
//        }
//    }


    //    private int[] dp = new int[4001];
//    private int front, back, pos;
//
//    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        for (int i : forbidden) {
//            dp[i] = -1;
//        }
//        front = a;
//        back = b;
//        pos = x;
//        jump(0, 0, false);
//        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
//    }
//
//    public void jump(int cur, int step, boolean tag) {
//        if (cur < 0 || cur > 4000 || step >= dp[cur]) return;
//        dp[cur] = step;
//        if (tag) {
//            jump(cur - back, 1 + step, false);
//        }
//        jump(cur + front, 1 + step, true);
//    }
    class Node {
        int p, s;//position state

        Node(int a, int b) {
            p = a;
            s = b;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = 4001;
        boolean[] ban = new boolean[max];
        Arrays.fill(ban, false);
        for (int i : forbidden) ban[i] = true;
        int[][] dp = new int[max][2];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        dp[0][0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));//初始值为0的意思是，由前进得到的这一步。
        while (!queue.isEmpty()) {
            int p = queue.peek().p, s = queue.peek().s;
            queue.poll();
            if (p + a < max && !ban[p + a] && dp[p + a][0] == -1) {
                dp[p + a][0] = dp[p][s] + 1;
                queue.add(new Node(p + a, 0));
            }
            if (s != 1 && p - b > -1 && !ban[p - b] && dp[p - b][1] == -1) {
                dp[p - b][1] = dp[p][s] + 1;
                queue.add(new Node(p - b, 1));
            }
        }
        if (dp[x][0] == -1 && dp[x][1] == -1) {
            return -1;
        } else {
            return dp[x][0] == -1 ? dp[x][1] : dp[x][0];
        }
    }
}
