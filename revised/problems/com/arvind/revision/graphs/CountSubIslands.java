package com.arvind.revision.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubIslands {

    private static final int[] DIR_I = {-1, 0, 1, 0};
    private static final int[] DIR_J = {0, 1, 0, -1};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        int m = grid2.length;
        int n = grid2[0].length;
        int[][] visited = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && grid2[i][j] == 1) {
                    System.out.println(i + ", " + j);
                    count += bfs(i, j, m, n, visited, grid1, grid2) ? 1 : 0;
                }
            }
        }
        return count;
    }

    private boolean bfs(int i, int j, int m, int n, int[][] visited, int[][] grid1, int[][] grid2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = 1;
        boolean flag = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            if (grid1[I][J] == 0) flag = false;

            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && grid2[newI][newJ] == 1) {
                    if (grid1[newI][newJ] == 0) flag = false;
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }
        System.out.println(flag);
        return flag;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        int[][] grid2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };
        CountSubIslands solution = new CountSubIslands();
        System.out.println(solution.countSubIslands(grid1, grid2));

    }
}
