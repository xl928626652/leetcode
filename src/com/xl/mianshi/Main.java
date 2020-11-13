package com.xl.mianshi;

import java.util.*;

public class Main {
    public int maxSumDivThree() {
        //Version : 7
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int n : nums) {
            int[] dp2 = new int[7];
            for (int i = 0; i < 7; i++) {
                dp2[(i + n) % 7] = Math.max(dp[(i + n) % 7], dp[i] + n);
            }
            dp = dp2;
        }
        if (dp[0] == 0) {
            return -1;
        } else {
            return dp[0];
        }
    }

    public void wangyi_no_1() {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] strings = s.trim().split(" ");
            int index = Integer.parseInt(strings[0]);
            ArrayList<Integer> tmp = map.getOrDefault(index, new ArrayList<Integer>());
            if (tmp.size() < 2) {
                tmp.add(Integer.parseInt(strings[2]));
            }
            map.put(index, tmp);
        }
        for (int i = 1; i <= m; i++) {
            if (map.get(i) == null || map.get(i).size() != 2) continue;
            int a=map.get(i).get(0),b=map.get(i).get(1);
            if(map.get(a) == null && map.get(b) ==null){
                count++;
            }
        }
        System.out.println(count);
    }


    public void diDi_no_1(){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n=scanner.nextInt(), m=scanner.nextInt(), k=scanner.nextInt();

        }
    }
    public static void main(String[] args) {
//        System.out.println(new Main().maxSumDivThree());
//        new Main().wangyi_no_1();

    }

}
