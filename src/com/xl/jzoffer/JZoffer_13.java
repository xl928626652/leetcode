package com.xl.jzoffer;

public class JZoffer_13 {
    int length,width;
    int count=0;
    public int movingCount(int m, int n, int k) {
        length=m;
        width=n;
        int[][] map = new int[m][n];
        dfs(0,0,k,map);
        return count;
    }
    public boolean dfs(int m, int n, int k, int[][] map){
        if(m<0 || n<0 || m >= length||n >= width || (m%10+m/10+n%10+n/10)>k) return false;
        if(map[m][n]==1) return false;
        count++;
        map[m][n]=1;
        dfs(m-1,n,k,map);
        dfs(m+1,n,k,map);
        dfs(m,n-1,k,map);
        dfs(m,n+1,k,map);
        /*这行代码刺激啊，不应该恢复，因为会重复计算，所以要考虑何时可以重复计算，比如找路径的时候，因为要考虑所有的路径
        * 但是这里只需要从（0,0）开始走，而且不需要重复计算*/
        //map[m][n]=0;
        return true;
    }

    public static void main(String[] args) {
        JZoffer_13 jZoffer_13=new JZoffer_13();
        jZoffer_13.movingCount(3,2,17);
        System.out.println(jZoffer_13.length);
        System.out.println(jZoffer_13.width);
        System.out.println(jZoffer_13.count);
    }
}
