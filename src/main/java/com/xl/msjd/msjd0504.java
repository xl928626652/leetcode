package com.xl.msjd;

public class msjd0504 {
    //这个暴力法爱了爱了
    public static int[] findClosedNumbers(int num) {
        int[] res = {-1, -1};
        long max = (long) num << 1;
        int min = num >> 1;
        int oneCount = countOneNum(num);
        for (int i = num + 1; i <= max; i ++) {
            if(oneCount == countOneNum(i)) {
                res[0] = i;
                break;
            }
        }
        for (int i = num - 1; i >= min; i --) {
            if(oneCount == countOneNum(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }


    public static int countOneNum(long num) {
        String str = Long.toBinaryString(num);
        int res = 0;
        for (int i = 0; i < str.length(); i ++) {
            if(str.charAt(i) == '1') {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a= Integer.bitCount(Integer.MAX_VALUE);
        System.out.println(a);//31
    }
//    作者：yu-da-xian-2
//    链接：https://leetcode-cn.com/problems/closed-number-lcci/solution/xia-yi-ge-shu-shuang-100-by-yu-da-xian-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
