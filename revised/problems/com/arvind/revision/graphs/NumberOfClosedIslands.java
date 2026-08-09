package com.arvind.revision.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfClosedIslands {

    public static final int LAND = 0;
    public static final int WATER = 1;
    public static final int[] DIR_I = {-1, 0, 1, 0};
    public static final int[] DIR_J = {0, 1, 0, -1};

    public int closedIsland(int[][] grid) {
        int count = 0;
        int m = grid.length;
        if (m < 3) return 0;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        for (int i=1; i<m-1; i++) {
            for (int j=1; j<n-1; j++) {
                if (visited[i][j] == 0 && grid[i][j] == LAND) {
                    if (bfs(i, j, m, n, grid, visited)) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    private boolean bfs(int i, int j, int m, int n, int[][] grid, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = 1;
        boolean flag = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            visited[I][J] = 1;

            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];

                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == LAND) {
                    if (isCorner(newI, newJ, m, n)) flag = false;
                    queue.offer(new int[] {newI, newJ});
                    visited[newI][newJ] = 1;
                }
            }

        }
        return flag;
    }

    private boolean isCorner(int i, int j, int m, int n) {
        return (i == 0 || i == m-1) || (j == 0 || j == n-1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        NumberOfClosedIslands solution = new NumberOfClosedIslands();
        System.out.println(solution.closedIsland(grid));
    }
}
