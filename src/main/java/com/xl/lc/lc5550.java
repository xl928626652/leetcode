package com.xl.lc;

public class lc5550 {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) return new int[code.length];
        int n = code.length;
        int[] res = new int[n];
        for (int i = 0; i < res.length; i++) {
            int index = k > 0 ? (i + 1) % n : (i - 1 + n) % n;
            int r = 0, tk = k;
            if (tk > 0) {
                while (tk != 0) {
                    r += code[index];
                    index = (index + 1) % n;
                    tk--;
                }
                res[i] = r;
            } else {
                tk = -tk;
                while (tk != 0) {
                    r += code[index];
                    index = (index - 1 + n) % n;
                    tk--;
                }
                res[i] = r;
            }
        }
        return res;
    }
}
