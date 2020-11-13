package com.xl.lc;

import java.util.Deque;
import java.util.LinkedList;

public class lc_862 {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        //这个想法很巧妙，for循环的每一次开始，monoq这个队列中，已经不存在符合要求的差值大于K的两个数，且这是单调的队列，
        // 所以对于新加的数来说，如果他比单调队列最大的数要小，那么首先他不能和之前的数一起，产生符合要求的差值大于K的组合。、
        //且，以后加进来的数，再也不会和它之前的那个比它大的数组成差值大于K的组合了，因为类似于213，k=1，3-1>3-2，所以一定不会有2这个数字什么事情。
        //所以要在第一个循环中，把比它大的那些数，从队列中删掉。这样子就会一直维护一个单调队列。
        //至于为什么要在符合要求k后，把队首元素删掉，是因为后面新来的数，对于当前这个队列而言，就算满足了减去队首元素符合要求，也不会是最优解，所以也没有后来加入的数字什么事情。
        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());
            monoq.addLast(y);
        }
        return ans < N+1 ? ans : -1;
    }
}
