package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    private static final int[] DIR_I = {-1, 0, 1, 0};
    private static final int[] DIR_J = {0, 1, 0, -1};

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j, 0}); // pass the number of steps
                    visited[i][j] = 1;
                }
            }
        }
        bfs(m, n, queue, rooms, visited);
    }

    private void bfs(int m, int n, Queue<int[]> queue, int[][] rooms, int[][] visited) {
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            int D = node[2];
            visited[I][J] = 1;
            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                int newD = D + 1;

                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && rooms[newI][newJ] != -1) {
                    rooms[newI][newJ] = newD;
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ, newD});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        WallsAndGates solution = new WallsAndGates();
        solution.wallsAndGates(rooms);
        CommonUtils.print(rooms);
    }
}
