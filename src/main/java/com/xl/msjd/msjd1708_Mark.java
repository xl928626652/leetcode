package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1708_Mark {
    //这道题本质是在维护一个递增队列，如果新的数大于队列中的数，就进队，否则就把队列中第一个大于他的值替换成他。
    // 还有一个小trick，就是把height相同的人的weight降序排列，这样子就可以很方便的用这个队列了，因为相同的height的人的weight最终只会取最低的那个。
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i)
            person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = pair[1];
            if (i == res)
                ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 2, 2, 3};
        int[] weight = new int[]{4, 2, 3, 4, 8};
        int res = new msjd1708_Mark().bestSeqAtIndex(height, weight);

        System.out.println(res);

//
//        int[][] nums = {{5, 0}, {6, 1}, {6, 2}};
//        //重写Comparator接口里面的compare方法，用Lambda表达式写比较简洁
//                //        Arrays.sort(nums, (o1, o2) -> o1[0] - o2[0]);
//        Arrays.sort(nums, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println("值：" + nums[i][0] + "   序号：" + nums[i][1]);
//        }
    }
//    作者：gfu
//    链接：https://leetcode-cn.com/problems/circus-tower-lcci/solution/xian-gen-ju-shen-gao-pai-xu-ruo-shen-gao-yi-yang-z/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
