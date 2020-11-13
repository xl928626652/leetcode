package com.xl.jzoffer;

import java.util.Deque;
import java.util.LinkedList;

public class jz_63 {
    public int maxProfit(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();
        int max=0;
        for (int i = 0; i < prices.length; i++) {
            if(deque.isEmpty()){
                deque.add(prices[i]);
            }else{
                if (prices[i]<deque.getFirst()){
                    while (!deque.isEmpty()){
                        deque.removeFirst();
                    }
                    deque.add(prices[i]);
                }else {
                    max=Math.max(max,prices[i]-deque.getFirst());
                    deque.add(prices[i]);
                }
            }

        }
        return max;
    }
    //Dp
//    public int maxProfit(int[] prices) {
//        if (prices.length<=1) return 0;
//        int[] dp = new int[prices.length];
//        dp[0] = 0;
//        int min=prices[0];
//        for (int i = 1; i < dp.length; i++) {
//            min=Math.min(prices[i],min);
//            dp[i]=Math.max(dp[i-1],prices[i]-min);
//        }
//        return dp[dp.length-1];
//    }
}
