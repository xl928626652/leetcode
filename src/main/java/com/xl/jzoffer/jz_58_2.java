package com.xl.jzoffer;

public class jz_58_2 {
    //比较蠢的方法
//    public String reverseLeftWords(String s, int n) {
//        StringBuilder stringBuilder = new StringBuilder();
//        String s1 = s.substring(0,n);
//        stringBuilder.append(s.substring(n,s.length()));
//        stringBuilder.append(s1);
//        return stringBuilder.toString();
//    }

    //String和char还能使用+运算符
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < s.length(); i++)
            res += s.charAt(i);
        for (int i = 0; i < n; i++)
            res += s.charAt(i);
        return res;
    }

    public static void main(String[] args) {
        String s = "123";
        s += 'c';
        System.out.println(s);
    }


}
