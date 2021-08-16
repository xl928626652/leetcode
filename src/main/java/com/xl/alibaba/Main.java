package com.xl.alibaba;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * @ClassName : Main
 * @Author : Xulian
 * @Date : 2021/3/4 18:52
 */
public class Main {
    int num = 0;
    int leave = 0;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        backTrack(0, ans, new ArrayList<>(), nums);
        return ans;
    }

    public void backTrack(int first, List<List<Integer>> ans, List<Integer> list, int[] nums) {

//        System.out.println(list);
        if (first == nums.length) {
            leave++;
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = first; i < nums.length; i++) {
                num++;
                list.add(nums[i]);
                swap(nums, first, i);
                backTrack(first + 1, ans, list, nums);
                swap(nums, first, i);
                list.remove(list.size() - 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int num2 = 0;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        boolean[] vis = new boolean[n];
        Arrays.sort(nums);
        backTrack(ans, new ArrayList<>(), vis, n, nums);
        return ans;
    }

    public void backTrack(List<List<Integer>> ans, List<Integer> list, boolean[] vis, int n, int[] nums) {

        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = 0; i < n; i++) {
            num2++;
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;
            backTrack(ans, list, vis, n, nums);
            vis[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public int lenOfLongestSub(String s) {
        //滑动窗口
        Map<Character, Integer> map = new HashMap<>();
        int left = -1, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
//        printALI();
        Main main = new Main();
        main.permute(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9});
        main.permuteUnique(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
//        5 * 4 * 3 * 2 * 1 =  20 * 6 = 120
        System.out.println(main.num);
        System.out.println(main.num2);
    }

    private static void printALI() {
        //使用三个信号量
        int n = 2;
        Semaphore A_Semaphore = new Semaphore(1);
        Semaphore L_Semaphore = new Semaphore(0);
        Semaphore I_Semaphore = new Semaphore(0);
        Thread t_a = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        A_Semaphore.acquire();
                        System.out.print("A");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        L_Semaphore.release();
                    }
                }
            }
        });
        Thread t_l = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        L_Semaphore.acquire();
                        System.out.print("L");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        I_Semaphore.release();
                    }
                }
            }
        });
        Thread t_i = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    try {
                        I_Semaphore.acquire();
                        System.out.print("I");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        A_Semaphore.release();
                    }
                }
            }
        });
        t_a.start();
        t_l.start();
        t_i.start();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
