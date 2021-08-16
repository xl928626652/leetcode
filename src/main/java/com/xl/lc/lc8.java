package com.xl.lc;

public class lc8 {
    public int myAtoi(String s) {
        long res = 0;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) return (int) res;
        char first = s.charAt(index);
        char flag;
        if (first == '-') {
            flag = '-';
        } else if (first == '+' || (first - '0' < 10 && first - '0' >= 0)) {
            flag = '+';
        } else {
            return (int) res;
        }
        int begin = index;
        if (first == '+' || first == '-') {
            index++;
        }
        int nonzero = index;
        while (index < s.length() && (s.charAt(index) - '0' < 10 && s.charAt(index) - '0' >= 0)) {
            index++;
        }

        int end = index;
        if (end - begin == 1 && (first == '+' || first == '-')) {
            return (int) res;
        }
        while (nonzero < s.length() && s.charAt(nonzero) == '0') {
            nonzero++;
        }
        if (end - nonzero > 14) {
            if (flag == '+') return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        res = Long.parseLong(s.substring(begin, end));
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }

    public static void main(String[] args) {
        String s = "20000000000000000000";
        int res = new lc8().myAtoi(s);
        System.out.println(res);
        System.out.println(Integer.parseInt("22222222"));

    }
}
