package com.arvind.revision.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int timeTaken = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int numberOfOnesSeen = 0;
        int totalNumberOfOnes = 0;
        int[][] visited = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 2) {
                    queue.offer(new int[] {i, j, 0});
                    visited[i][j] = 1;
                }
                if (grid[i][j] == 1) {
                    totalNumberOfOnes++;
                }
            }
        }

        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            int time = node[2];
            visited[I][J] = 1;
            timeTaken = time;
            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                int newTime = time + 1;
                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && grid[newI][newJ] == 1) {
                    visited[newI][newJ] = 1;
                    numberOfOnesSeen++;
                    queue.offer(new int[] {newI, newJ, newTime});
                }

            }
        }

        return numberOfOnesSeen == totalNumberOfOnes ? timeTaken : -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid2 = new int[][] {{1, 2}};
        RottingOranges solution = new RottingOranges();
        System.out.println(solution.orangesRotting(grid2));
    }
}
