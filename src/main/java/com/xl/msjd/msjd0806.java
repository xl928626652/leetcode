package com.xl.msjd;

import java.util.List;

public class msjd0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int len = A.size();
        recur(len, A, B, C);
    }

    public void recur(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        recur(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        recur(n - 1, B, A, C);
    }
}
