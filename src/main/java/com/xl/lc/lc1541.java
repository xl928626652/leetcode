package com.xl.lc;

/**
 * @ClassName : lc1541
 * @Author : Xulian
 * @Date : 2020/10/18 19:24
 */
public class lc1541 {
    public int minInsertions(String s) {
        char[] chars = s.toCharArray();
        int res = 0;//最后的操作次数
        int left = 0; //代表当前观察到的左括号的个数。
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (i < chars.length - 1 && chars[i + 1] == ')') {
                    if (left > 0) {
                        left--;//有左括号就直接用，并且把个数减一
                    } else {
                        res++;//没有左括号了就操作一次
                    }
                    i++;//意思是跳过已经看了的下个右括号
                } else {
                    if (left > 0) {
                        left--;//有左括号就直接用，并且把个数减一
                        res++;//还缺一个右括号
                    } else {
                        res += 2;//左括号和右括号都缺
                    }
                }
            } else {
                left++;
            }
        }
        res += left * 2;
        return res;
    }
}
