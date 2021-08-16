package com.xl.alibaba;

import java.io.*;
import java.util.*;

/**
 * @ClassName : Competion
 * @Author : Xulian
 * @Date : 2021/3/10 17:20
 */
public class Competion {
    //对于很多个数一行的，需要这样写入
    public void test1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strSeq = br.readLine().trim().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strSeq[i]);
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(i + 1 - nums[i]);
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for (int d = 0; d < T; d++) {
            int n = Integer.parseInt(reader.readLine());
            String s = reader.readLine();
            int m = Integer.parseInt(reader.readLine());
            String sex = reader.readLine();

            PriorityQueue<Integer> one = new PriorityQueue<>();
            PriorityQueue<Integer> zero = new PriorityQueue<>();
            int[] ans = new int[m];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zero.add(i + 1);
                } else if (s.charAt(i) == '1') {
                    one.add(i + 1);
                }
            }
            for (int i = 0; i < sex.length(); i++) {
                char c = sex.charAt(i);
                if (c == 'F') {
                    if (!zero.isEmpty()) {
                        ans[i] = zero.peek();
                        one.add(zero.poll());
                    } else {
                        ans[i] = one.poll();

                    }
                } else {
                    if (!one.isEmpty()) {
                        ans[i] = one.poll();
                    } else {
                        ans[i] = zero.peek();
                        one.add(zero.poll());
                    }
                }
            }
            for (int i : ans) {
                writer.write(i + "\n");
            }
            writer.flush();
        }
    }

}
