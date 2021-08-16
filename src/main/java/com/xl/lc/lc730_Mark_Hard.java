package com.xl.lc;

/**
 * @ClassName : lc730
 * @Author : Xulian
 * @Date : 2020/11/18 22:11
 */
public class lc730_Mark_Hard {
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int[][] dp = new int[n][n]; // dp[i][j]表示[i,j]下标范围内的回文子序列数量
        char[] ch = S.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {//长度从2开始
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (ch[i] != ch[j]) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]; // 两个子区间的dp值减去重复计算后的dp值
                } else {
                    dp[i][j] = dp[i + 1][j - 1] * 2; //两端重复数相当于子串的回文数 * 2
                    /*
                    例:  b......b 中......的子序列为{x}
                    那么 b + {x} + b    也是回文串 所以乘2
                     */

                    //去重及增加回文串
                    int l = i + 1, r = j - 1;
                    while (l <= r && ch[l] != ch[i]) l += 1;
                    while (l <= r && ch[r] != ch[i]) r -= 1;

                    if (l > r) dp[i][j] += 2;
                    /*  例"b.....b"

                        因为l 和 r 只有遇到值端点才会停下  如果l > r 说明 子区间中无端点值
                        当 除端点外的子区间[.....] 中没有端点值时 增加b 和 bb两种回文序列

                     */
                    else if (l == r) dp[i][j] += 1;
                    /*  例："b[..b..]b"
                        因为l 和 r 只有遇到端点值才会停下 如果l = r
                        证明除端点外的子区间中[..b..]  仅含有一个端点值且在最中间(如果含有两个及以上，l和r必定停在不同位置)

                        因为单个的端点值b已经出现过,无法增加。所以只能增加bb，因此 + 1

                     */
                    else dp[i][j] -= dp[l + 1][r - 1];
                    /*
                        例b1..b2[...]b2..b1  因为l 和 r  只有遇到端点才会停下

                        如果l < r 则当 除端点之外的子区间中..b[...]b.. 中至少含有两个端点值
                        此时考虑子区间[...]的回文子序列为{x}, 则b1 + {x} + b1 和b2 + {x} + b2组成的子序列其实是一样的
                        我们在乘算的时候就多考虑了这一部分序列 所以要减去[...]的子序列数

                        且b 和 bb 都在子序列b2[...]b2中出现过了 也就没必要加上去

                     */
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][n - 1];
    }
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/count-different-palindromic-subsequences/solution/tong-ji-bu-tong-hui-wen-zi-zi-fu-chuan-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
