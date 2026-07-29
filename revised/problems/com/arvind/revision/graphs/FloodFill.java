package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] visited = new int[m][n];
        int existingColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        // put the src in the queue
        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = 1;
        image[sr][sc] = color;
        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];

            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && image[newI][newJ] == existingColor) {
                    visited[newI][newJ] = 1;
                    image[newI][newJ] = color;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        FloodFill solution = new FloodFill();
        CommonUtils.print(solution.floodFill(image, sr, sc, color));
    }
}
