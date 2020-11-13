package com.xl.jzoffer;

public class jz_67 {
    public int strToInt(String str) {
        // str = str.trim();
        char[] chars = str.toCharArray();

        int res = 0;    // 转换结果
        int sign = 1;   // 表示 符号位，直接与结果相乘 即可
        int index = 1;  // 遍历 chars数组 的 下标
        int border = Integer.MAX_VALUE / 10;    // 用于判断 当前数字 是否 到达最大值 的1/10，以便后续处理

        if (chars.length <= 0) {
            return 0;
        }

        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            index = 0;
        }

        for (; index < chars.length; index++) {
            char curChar = chars[index];
            if (curChar < '0' || curChar > '9') {
                break;
            }
            if (res > border || (res == border && curChar>'7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + curChar - '0';
        }

        return sign * res;
    }
}
