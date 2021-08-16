package com.xl.lc;

import java.util.Arrays;

/**
 * @ClassName : lc973
 * @Author : Xulian
 * @Date : 2020/11/9 14:14
 */
public class lc973_Mark_Mark_kTH {
    int num;
    int[][] res;

    //我的理解是，有可能pivot还没有到K - 1的地方，排序就结束了，所以这个时候不能在方法体里面赋值，要在最外面赋值！
    public int[][] kClosest(int[][] points, int K) {
        num = K;
        res = new int[num][2];
        quickSort(0, points.length - 1, points);
        res = Arrays.copyOfRange(points, 0, num);
        return res;
    }

    public void quickSort(int first, int end, int[][] nums) {
        if (first >= end) {
            return;
        } else {
            int pivot = partition(first, end, nums);
            if (pivot == num - 1) {
                return;
            } else if (pivot < num - 1) {
                quickSort(pivot + 1, end, nums);
            } else {
                quickSort(first, pivot - 1, nums);
            }
            // quickSort(first,pivot - 1, nums);
            // quickSort(pivot + 1,end, nums);
        }
    }

    public int partition(int first, int end, int[][] nums) {
        int i = first, j = end;
        while (i < j) {
            while (i < j && closer(nums, i, j)) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
                i++;
            }
            while (i < j && closer(nums, i, j)) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
                j--;
            }
        }
        return i;
    }

    public void swap(int[][] nums, int a, int b) {
        int[] temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public boolean closer(int[][] points, int i, int j) {
        int x1 = points[i][0], y1 = points[i][1];
        int x2 = points[j][0], y2 = points[j][1];
        return (x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2) <= 0;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,1},{1,0}};
        int K = 2;
        new lc973_Mark_Mark_kTH().kClosest(points, K);
//        System.out.println(Arrays.toString(points[0])+""+ Arrays.toString(points[1]));
//        int[][] res = Arrays.copyOfRange(points,0,2);
//        System.out.println(Arrays.toString(res[0])+""+ Arrays.toString(res[1]));
//        System.out.println(Arrays.toString(res[0]));
    }
    //    public int[][] kClosest(int[][] points, int K) {
//        int num = K;
//        int[][] res = new int[num][2];
//        PriorityQueue<Integer> queue = new PriorityQueue<>(num, (o1, o2) -> {
//            int x1 = points[o2][0], y1 = points[o2][1];
//            int x2 = points[o1][0], y2 = points[o1][1];
//            return x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2;
//        });
//        for (int i = 0; i < points.length; i++) {
//            int x = points[i][0], y = points[i][1];
//            if (queue.size() < num) {
//                queue.add(i);
//            } else {
//                int max = queue.peek();
//                int x1 = points[max][0], y1 = points[max][1];
//                double len1 = Math.sqrt(x1 * x1 + y1 * y1);
//                double len = Math.sqrt(x *x + y* y);
//                if (len < len1){
//                    queue.poll();
//                    queue.add(i);
//                }
//            }
//        }
//        for (int[] e : res){
//             int i = queue.poll();
//             e[0] = points[i][0];
//             e[1] = points[i][1];
//        }
//        return res;
//    }
    //这个可以直接传int[]
//public int[][] kClosest(int[][] points, int K) {
//    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (cal(b) - cal(a)));
//    int[][] result = new int[K][2];
//    for(int i = 0; i < K; i++){
//        maxHeap.offer(points[i]);
//    }
//    for(int i = K; i < points.length; i++){
//        if(cal(maxHeap.peek()) > cal(points[i])){
//            maxHeap.poll();
//            maxHeap.offer(points[i]);
//        }
//    }
//    for(int i = 0; i < K; i++){
//        result[i] = maxHeap.poll();
//    }
//    return result;
//}
//
//    public int cal(int a[]){
//        return (a[0] * a[0]) + (a[1] * a[1]);
//    }
//
//    作者：donoghl
//    链接：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/java-top-k-3-by-donoghl/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//    public int[][] kClosest(int[][] points, int K) {
//        int num = K;
//        int[][] res = new int[num][2];
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o2, o1) -> {
//            int x1 = points[o2][0], y1 = points[o2][1];
//            int x2 = points[o1][0], y2 = points[o1][1];
//            return x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2;
//        });
//        for (int i = 0; i < points.length; i++) {
//            queue.add(i);
//        }
//        for (int[] e : res) {
//            int i = queue.poll();
//            e[0] = points[i][0];
//            e[1] = points[i][1];
//        }
//        return res;
//    }
}
