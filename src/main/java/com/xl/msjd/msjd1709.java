package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1709 {
    //这道题的核心其实是 因数只包含3 5 7的数，是由之前的一个数 * 3 or * 5 or * 7 得到的。所以这是两个序列去除重复得到的。
    //ugly[0]*3,ugly[1]*3,ugly[2]*3,ugly[3]*3,ugly[4]*3,ugly[5]*3……
    //ugly[0]*5,ugly[1]*5,ugly[2]*5,ugly[3]*5,ugly[4]*5,ugly[5]*5……
    //ugly[0]*7,ugly[1]*7,ugly[2]*7,ugly[3]*7,ugly[4]*7,ugly[5]*7……
    public int getKthMagicNumber(int k) {
        int aIndex = 0, bIndex = 0, cIndex = 0;
        int[] res = new int[k];
        res[0] = 1;
        int i = 1;
        while (i < k) {
            res[i] = Math.min(Math.min(res[aIndex] * 3, res[bIndex] * 5), res[cIndex] * 7);
            //为了去重，就要这样搞，很巧妙。
            if (res[i] == res[aIndex] * 3) aIndex++;
            if (res[i] == res[bIndex] * 5) bIndex++;
            if (res[i] == res[cIndex] * 7) cIndex++;
            i++;
        }
        return res[k - 1];
    }

    public static void main(String[] args) {
        new msjd1709().getKthMagicNumber(8);
    }

//    作者：chen-jia-hui-2
//    链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci/solution/san-zhi-zhen-tu-jie-by-chen-jia-hui-2-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
