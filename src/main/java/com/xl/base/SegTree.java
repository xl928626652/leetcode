package com.xl.base;


/**
 * @ClassName : SegTree
 * @Author : Xulian
 * @Date : 2020/11/12 15:41
 */
public class SegTree {
    int n;
    int[] arr;
    int[] lazy;

    public SegTree(int num) {
        n = num;
        arr = new int[num * 4];
        lazy = new int[num * 4];
    }

    public void up(int rt) {
        arr[rt] = arr[rt << 1] + arr[(rt << 1 | 1)];
    }

    public void build(int l, int r, int rt) {
        if (l == r) {
            arr[rt] = 0;
        } else {
            int m = l + (r - l) / 2;
            build(l, m, rt << 1);
            build(m + 1, r, (rt << 1) | 1);
            up(rt);
        }
    }

    public void down(int rt, int ln, int rn) {
        if (lazy[rt] > 0) {
            lazy[rt << 1] += lazy[rt];
            lazy[rt << 1 | 1] += lazy[rt];
            arr[rt << 1] += lazy[rt] * ln;
            arr[rt << 1 | 1] += lazy[rt] * rn;
            lazy[rt] = 0;
        }
    }

    public void update(int x, int c, int l, int r, int rt) {
        if (l == r) {
            arr[rt] += c;
        }else{
            int m = l + (r - l) / 2;
            if (x <= m) update(x, c, l, m, rt << 1);
            else update(x, c, m + 1, r, rt << 1 | 1);
            up(rt);
        }
    }

    public void update(int x, int y, int c, int l, int r, int rt) {
        if (x <= l && y >= r) {
            arr[rt] += (r - l + 1) * c;
            lazy[rt] += c;
            return;
        }
        int m = (l + r) / 2;
        down(rt, m - l + 1, r - m);
        if (x <= m) update(x, y, c, l, m, rt << 1);
        if (y < m) update(x, y, c, m + 1, r, rt << 1 | 1);
        up(rt);
    }

    public long query(int x, int y, int l, int r, int rt) {
        if (x <= l && y >= r) {
            return arr[rt];
        }
        long ans = 0;
        int m = (l + r) / 2;
        down(rt, m - l + 1, r - m);
        if (x <= m) ans += query(x, y, l, m, rt << 1);
        if (y > m) ans += query(x, y, m + 1, r, rt << 1 | 1);
//        up(rt);
        return ans;
    }

    public static void main(String[] args) {
        int a = 2;
        int k = a << 1 | 1;
        System.out.println(k);
    }
}
