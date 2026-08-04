package com.arvind.revision.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public static final int[] DIR_I = {-1, 0, 1, 0};
    public static final int[] DIR_J = {0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int maxArea = Integer.MIN_VALUE;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    visited[i][j] = 1;
                    maxArea = Math.max(bfs(i, j, m, n, grid, visited), maxArea);
                }
            }
        }

        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private int bfs(int i, int j, int m, int n, int[][] grid, int[][] visited) {
        int currArea = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            currArea++;
            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }

        return currArea;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
