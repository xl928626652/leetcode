package com.xl.msjd;

/**
 * @ClassName : msjd1003
 * @Author : Xulian
 * @Date : 2020/10/4 17:34
 */
public class msjd1003_Mafan {
    public int search(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            //如果最左边就是target
            if (arr[left] == target && (left - 1 < 0 || arr[left - 1] != target)) return left;
            //如果中间是target
            if (arr[mid] == target && (mid - 1 < 0 || arr[mid - 1] != target)) return mid;
            //如果左边不是递增的
            if (arr[mid] < arr[left]) {
                //此时如果元素在左边就向左缩区间
                if (target > arr[left] || target < arr[mid]) right = mid - 1;
                    //否则向右缩
                else left = mid + 1;
            }
            //如果左边是递增的
            else if (arr[mid] > arr[left]) {
                //此时如果元素在右边就向右缩区间
                if (target > arr[mid] || target < arr[left]) left = mid + 1;
                    //否则向左缩
                else right = mid - 1;
            }
            //若中间元素和最左边元素相等，无法判断左边是不是递增，比如[2, 1, 2, 2, 2]和[2, 2, 2, 1, 2]，将左区间向右移动一位
            else ++left;
        }
        return -1;
    }
}
