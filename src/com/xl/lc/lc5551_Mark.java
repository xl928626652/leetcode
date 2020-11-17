package com.xl.lc;

public class lc5551_Mark {
    //    public int minimumDeletions(String s) {
//        int cnt = 0;
//        int dp = 0;
//        char[] chars = s.toCharArray();
//        for(char c : chars){
//            if(c == 'a'){
//                if(cnt == dp){
//
//                }else{
//                    dp++;
//                }
//            }else{
//                cnt++;
//            }
//        }
//        return dp;
//    }
    public int minimumDeletions(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        a[0] = 0;
        b[n] = 0;
        for (int i = 1; i < a.length; i++) {
            if (chars[i - 1] != 'a') {
                a[i] = a[i - 1] + 1;
            } else {
                a[i] = a[i - 1];
            }
        }
        for (int i = n - 1; i > -1; i--) {
            if (chars[i] != 'b') {
                b[i] = b[i + 1] + 1;
            } else {
                b[i] = b[i + 1];
            }
        }
        int ans = a[0] + b[0];
        for (int i = 0; i <= n; i++) {
            ans = Math.min(a[i] + b[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(new lc5551_Mark().minimumDeletions(s));
    }
}
