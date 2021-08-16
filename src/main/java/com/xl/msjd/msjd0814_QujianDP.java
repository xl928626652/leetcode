package com.xl.msjd;

/**
 * @ClassName : msjd0811
 * @Author : Xulian
 * @Date : 2020/10/3 20:53
 */
public class msjd0814_QujianDP {
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for(int len = 1; len <= n; len += 2){//枚举区间长度 1 3 5
            for(int i = 0; i + len - 1 < n; i += 2){ //区间左端点i 右端点i+len-1
                if(len == 1){
                    dp[i][i + len - 1][s.charAt(i) == '0' ? 0 : 1]++;
                }
                for(int j = i + 1; j < i + len - 1; j += 2){  //区间内操作符
                    char op = s.charAt(j);
                    switch(op){
                        case '&'://得0：  0&0 0&1 1&0   得1： 1&1
                            dp[i][i + len - 1][0] += dp[i][j - 1][0] * (dp[j + 1][i + len - 1][0] + dp[j + 1][i + len - 1][1]) +
                                    dp[i][j - 1][1] * dp[j + 1][i + len - 1][0];
                            dp[i][i + len - 1][1] += dp[i][j - 1][1] * dp[j + 1][i + len - 1][1];
                            break;
                        case '|':
                            dp[i][i + len - 1][0] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][0];
                            dp[i][i + len - 1][1] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][1] +
                                    dp[i][j - 1][1] * (dp[j + 1][i + len - 1][0] + dp[j + 1][i + len - 1][1]);
                            break;
                        case '^':
                            dp[i][i + len - 1][0] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][0] + dp[i][j - 1][1] * dp[j + 1][i + len - 1][1];
                            dp[i][i + len - 1][1] += dp[i][j - 1][0] * dp[j + 1][i + len - 1][1] + dp[i][j - 1][1] * dp[j + 1][i + len - 1][0];
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return dp[0][n - 1][result];
    }
}
