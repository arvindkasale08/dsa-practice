package com.arvind.revision.graphs;

import java.util.*;

public class NoOfDistinctIslands {

    private static int[] DIR_I = {-1, 0, 1, 0};
    private static int[] DIR_J = {0, 1, 0, -1};

    public int numDistinctIslands(int[][] grid) {
        Set<String> res = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    res.add(bfs(i, j, m, n, visited, grid));
                }
            }
        }
        return res.size();
    }

    private String bfs(int i, int j, int m, int n, int[][] visited, int[][] grid) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j});
        visited[i][j] = 1;
        sb.append(concat(i-i, j-j));

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];

            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];

                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ});
                    sb.append(concat(newI-i, newJ-j));
                }
            }
        }

        return sb.toString();
    }

    private String concat(int i, int j) {
        return i + "_" + j + ", ";
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };
        NoOfDistinctIslands solution = new NoOfDistinctIslands();
        System.out.println(solution.numDistinctIslands(grid));
    }
}
