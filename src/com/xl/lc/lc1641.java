package com.xl.lc;

/**
 * @ClassName : lc1641
 * @Author : Xulian
 * @Date : 2020/11/2 15:25
 */
public class lc1641 {
//    int count;
//    public int countVowelStrings(int n) {
//        count = 0;
//        List<Character> list = new ArrayList<>();
//        char[] chars = new char[]{'a','e','i','o','u'};
//        recur(0,n,chars,list);
//        return count;
//    }
//    public void recur(int k, int n, char[] chars,List<Character> list){
//        if (k == n){
//            count++;
//            return;
//        }
//        for (int i = 0; i < 5; i++) {
//            if(list.size()==0 || (list.get(list.size()-1 ) - chars[i] <= 0)){
//                list.add(chars[i]);
//                recur(k+1, n, chars, list);
//                list.remove(list.size()-1);
//            }
//        }
//    }

    //dp
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        for (int i = 0; i < 5; i++){
            dp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++){
            dp[i][4] = dp[i - 1][4] + dp[i - 1][3] + dp[i - 1][2] + dp[i - 1][1] + dp[i - 1][0];
            dp[i][3] = dp[i - 1][3] + dp[i - 1][2] + dp[i - 1][1] + dp[i - 1][0];
            dp[i][2] = dp[i - 1][2] + dp[i - 1][1] + dp[i - 1][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
            dp[i][0] = dp[i - 1][0];
        }
        return dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4];

    }
}
