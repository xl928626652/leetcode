package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1706_Hard_Mark {
    //这道题是真的很好，主要的陷阱就在于2的个数是要不断算的，比如22，你要不断的算，算2遍，才能全部算出来
    public int numberOf2sInRange(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int left = 0, right = 0;
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            int c = s.charAt(i) - '0';
            //当前字符左边表示的数字，若没有就是0
            left = i == 0 ? 0 : Integer.parseInt(s.substring(0, i));
            if (c > 2) left += 1;
            res += left * Math.pow(10, len - 1 - i);
            if (c == 2) {
                //当前字符右边表示的数字，若没有就是0
                right = i + 1 == len ? 0 : Integer.parseInt(s.substring(i + 1, len));
                res += right + 1; //注意包括了0的情况
            }
        }
        return res;
    }

    //    作者：tian-ye
//    链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci/solution/javashuang-100-shu-xue-ji-suan-by-tian-ye/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
//        String s = "123456";
//        //注意这里的范围，java里都是左闭右开
//        System.out.println(s.substring(0, s.length() - 1));
//        System.out.println(Math.pow(10, 0));
        int n =25;
        int res = new msjd1706_Hard_Mark().numberOf2sInRange(n);
        System.out.println(res);
    }

}
