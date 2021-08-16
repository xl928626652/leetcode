package com.xl.lc;

import java.util.PriorityQueue;

/**
 * @ClassName : lc1642
 * @Author : Xulian
 * @Date : 2020/11/2 15:26
 */
public class lc1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int index = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                int num = heights[i] - heights[i - 1];
                priorityQueue.offer(num);
                if (bricks >= num) {
                    bricks -= num;
                    index = i;
                    continue;
                }
                while (bricks < num) {
                    if (ladders <= 0) {
                        return index;
                    } else {
                        if (priorityQueue.size()!=0){
                            bricks += priorityQueue.poll();
                            ladders--;
                        }else{
                            ladders--;
                            index = i;
                            break;
                        }
                    }
                }
                bricks -= num;
                index = i;
            }else{
                index = i;
            }

        }
        return index;
    }
}
