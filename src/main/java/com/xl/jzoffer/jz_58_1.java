package com.xl.jzoffer;

import java.util.Arrays;

public class jz_58_1 {
    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        int left = 0, right = strings.length - 1;
        String tmp = "";
        while (left < right) {
            tmp = strings[left];
            strings[left++] = strings[right];
            strings[right--] = tmp;
        }
        StringBuilder res= new StringBuilder();
        for (String s1 : strings){
            s1=s1.replace(" ","");
            if(s1.equals("")) continue;
            res.append(s1).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(new jz_58_1().reverseWords(s));

    }
}
