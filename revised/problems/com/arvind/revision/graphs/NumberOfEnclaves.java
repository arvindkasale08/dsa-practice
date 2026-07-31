package com.arvind.revision.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    int[] DIR_I = {-1, 0, 1, 0};
    int[] DIR_J = {0, 1, 0, -1};

    public int numEnclaves(int[][] grid) {
        int enclaveCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(m, n, queue, grid);
        // count the number of enclaves;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    enclaveCount++;
                }
            }
        }
        return enclaveCount;
    }

    private void bfs(int m, int n, Queue<int[]> queue, int[][] grid) {

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];

            for (int k = 0; k < 4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];

                if (newI > -1 && newI < m && newJ > -1 && newJ < n && grid[newI][newJ] == 1) {
                    grid[newI][newJ] = 0;
                    queue.offer(new int[]{newI, newJ});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        NumberOfEnclaves solution = new NumberOfEnclaves();
        System.out.println(solution.numEnclaves(grid));
    }
}
