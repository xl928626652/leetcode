package com.xl.msjd;

public class msjd0501_Mark {
    /**
    * @Description: TODO
    * @Param: [N, M, i, j]
    * @return: int
    * @Author: Mr.Xu
    * @Date: 2020/9/29
    */
    public int insertBits(int N, int M, int i, int j) {
        StringBuilder sb_N = new StringBuilder(Integer.toBinaryString(N)),
                sb_M = new StringBuilder(Integer.toBinaryString(M));
        int remain = 32 - sb_N.length();
        while (--remain > -1) sb_N.insert(0, '0');
        remain = j - i + 1 - sb_M.length();
        while (--remain > -1) sb_M.insert(0, '0');
        sb_N.replace(31 - j, 32 - i, sb_M.toString());
        return Integer.parseInt(sb_N.toString(), 2);
    }

//    作者：gfu
//    链接：https://leetcode-cn.com/problems/insert-into-bits-lcci/solution/zhuan-string-by-gfu/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
