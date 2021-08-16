package com.xl.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : lc1542
 * @Author : Xulian
 * @Date : 2020/10/31 17:17
 */
public class lc1542 {
    //状态压缩 + 前缀和 + hash表
    public int longestAwesome(String s) {
        int status = 0, max = 1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            status ^= (1 << (cur - '0'));
            if (!map.containsKey(status)){
                map.put(status, i);
            }else{
                max = Math.max(max, i - map.get(status));
            }
            for (int j = 0; j < 10; j++){
                int temp = status ^ (1 << j);
                if (map.containsKey(temp)){
                    max = Math.max(max, i - map.get(temp));
                }
            }
        }
        return max;
    }
}
