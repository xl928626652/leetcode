package com.xl.msjd;

public class msjd0805 {
    public int multiply(int A, int B) {
        return A >= B ? recur(B, A) : recur(A, B);
    }

    public int recur(int A, int B) {
        return A == 0 ? 0 : (B + multiply(A - 1, B));
    }
}
