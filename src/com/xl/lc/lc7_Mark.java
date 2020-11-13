package com.xl.lc;

/**
 * @ClassName : lc7
 * @Author : Xulian
 * @Date : 2020/11/12 17:33
 */
public class lc7_Mark {
//    public int reverse(int x) {
//        int result = 0;
//        while (x != 0) {
//            int tmp = result; // 保存计算之前的结果
//            result = (result * 10) + (x % 10);
//            x /= 10;
//            // 将计算之后的结果 / 10，判断是否与计算之前相同，如果不同，证明发生溢出，返回0
//            if (result / 10 != tmp) return 0;
//        }
//        return result;
//    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
//    public int reverse(int x) {
//        StringBuilder sb = new StringBuilder(String.valueOf(x));
//        char flag = '+';
//        if (sb.charAt(0) == '-') {
//            flag = '-';
//            sb.deleteCharAt(0);
//        }
//        long res = 0;
//        char[] chars = sb.toString().toCharArray();
//        for (int i = 0; i < chars.length / 2; i++) {
//            char tmp = chars[i];
//            chars[i] = chars[chars.length - 1 - i];
//            chars[chars.length - 1 - i] = tmp;
//        }
//        String str = String.valueOf(chars);
//        sb.delete(0, sb.length());
//        if (flag == '-') {
//            sb.append("-");
//        }
//        sb.append(str);
//        res = Long.parseLong(sb.toString());
//        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
//            return 0;
//        } else {
//            return (int) res;
//        }
//    }

    public static void main(String[] args) {
        int a = 123;
        new lc7_Mark().reverse(a);

    }
}
