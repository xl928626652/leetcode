package com.xl.msjd;

public class msjd0810 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        recur(image, sr, sc, newColor, visited, image[sr][sc]);
        return image;
    }

    public void recur(int[][] image, int i, int j, int newColor, boolean[][] visited, int preColar) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || visited[i][j] || image[i][j] != preColar) {
            return;
        }
        visited[i][j] = true;
        image[i][j] = newColor;
        recur(image, i - 1, j, newColor, visited, preColar);
        recur(image, i, j - 1, newColor, visited, preColar);
        recur(image, i, j + 1, newColor, visited, preColar);
        recur(image, i + 1, j, newColor, visited, preColar);
    }
}
