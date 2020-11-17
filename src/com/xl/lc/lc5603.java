package com.xl.lc;

import java.util.HashMap;
import java.util.Map;

public class lc5603 {
    //    int res;
//
//    public int minOperations(int[] nums, int x) {
//        res = nums.length + 1;
//        recur(nums, x, 0, 0, nums.length - 1);
//        return res == nums.length + 1 ? -1 : res;
//    }
//
//    public void recur(int[] nums, int x, int count, int left, int right) {
//        if (x < 0) {
//            return;
//        }
//        if (x == 0) {
//            res = Math.min(res, count);
//        }
//        if (left > right) {
//            return;
//        }
//
//        recur(nums, x - nums[left], count + 1, left + 1, right);
//        recur(nums, x - nums[right], count + 1, left, right - 1);
//    }
//    public int minOperations(int[] nums, int x) {
//
//        int[] pre = new int[nums.length + 1];
//        for (int i = 1; i < pre.length; i++) {
//            pre[i] = pre[i-1] + nums[i - 1];
//        }
//        int res = nums.length + 1;
//        int max = pre[pre.length - 1];
//        if (max == x) return nums.length;
//        for (int i = 1; i < pre.length; i++) {
//            for (int j = i; j < pre.length; j++) {
//                int preSum = pre[j] - pre[i - 1];
//                if (max - preSum == x) {
//                    res = Math.min(res, nums.length - (j - i + 1));
//                }else if (max - preSum > x){
//                }else{
//                    break;
//                }
//            }
//        }
//        return res == nums.length + 1? -1: res;
//    }
//    public int minOperations(int[] nums, int x) {
//        int[] pre = new int[nums.length + 1];
//        for (int i = 1; i < pre.length; i++) {
//            pre[i] = pre[i-1] + nums[i - 1];
//        }
//        int res = nums.length + 1;
//        int max = pre[pre.length - 1];
//        if (max < x) return -1;
//        if (max == x) return nums.length;
//        int left = 1,right = 1;
//        int sum = 0;
//        while (left <= right){
//            sum += pre[right] - pre[left - 1];
//            if (max - sum < x) {
//                left ++;
//            }else if (max - sum > x){
//                right++;
//            }else{
//                res = Math.min(res, nums.length - (right - left + 1));
//            }
//        }
//        return res == nums.length + 1? -1: res;
//    }
    //大佬的解法
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ps = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            ps += nums[i];
            map.putIfAbsent(ps, i);
        }
        ps = 0;
        int inf = (int) 1e9;
        int ans = inf;
        for (int i = n; i >= 0; i--) {
            if (i < n) {
                ps += nums[i];
            }
            int target = x - ps;
            if (map.containsKey(target)) {
                int left = map.get(target);
                if (left < i) {
                    ans = Math.min(ans, left + 1 + n - i);
                }
            }
        }
        return ans == inf ? -1 : ans;
    }

    public static void main(String[] args) {
//            [1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136]
//        894887480
//        int[] nums = new int[]{1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136};
//        int x = 894887480;
//        System.out.println(new lc5603().minOperations(nums, x));
//        [8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309]
//        134365
        int[] nums = new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        int x = 134365;
        System.out.println(new lc5603().minOperations(nums, x));
    }
}
