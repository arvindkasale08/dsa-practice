package com.arvind.revision.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    bfs(i, j, m, n, visited, grid);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private void bfs(int i, int j, int m, int n, int[][] visited, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = 0;
        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            // go to valid neighbors
            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == '1') {
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        NumberOfIslands solution = new NumberOfIslands();
        System.out.println(solution.numIslands(grid));
    }
}
