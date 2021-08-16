package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class jz_62 {
//    public int lastRemaining(int n, int m) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i);
//        }
//        int index = 0;
//        while (list.size() > 1) {
//            index = (m + index - 1) % list.size();
//            list.remove(index);
//        }
//        return list.get(0);
//    }
    //约瑟夫环 反推 https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


}
