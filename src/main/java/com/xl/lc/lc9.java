package com.xl.lc;

public class lc9 {
    //字符串
//    public boolean isPalindrome(int x) {
//        boolean res = true;
//        String num = Integer.toString(x);
//        int left = 0, right = num.length() - 1;
//        while (left < right && res) {
//            if (num.charAt(left++) != num.charAt(right--)) {
//                res = false;
//            }
//        }
//        return res;
//    }

    //数学计算
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int x_reverse = 0, x_tmp = x;
        while (x_tmp != 0) {
            int a = x_tmp % 10;
            x_reverse = x_reverse * 10 + a;
            x_tmp /= 10;
        }
        return x_reverse == x;
    }
}
