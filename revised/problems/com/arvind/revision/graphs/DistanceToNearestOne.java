package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceToNearestOne {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // do a bfs from all 0s and find the distance;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && mat[i][j] == 0) {
                    visited[i][j] = 1;
                    queue.offer(new int[] {i, j, 0});
                }
            }
        }
        bfs(m, n, queue, mat, visited);
        return mat;
    }

    private void bfs(int m, int n, Queue<int[]> queue, int[][] mat, int[][] visited) {
        int[] DIR_I = {-1, 0, 1, 0};
        int[] DIR_J = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];
            int dist = node[2];
            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];
                int newDist = dist + 1;

                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && mat[newI][newJ] == 1) {
                    mat[newI][newJ] = newDist;
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ, newDist});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        DistanceToNearestOne solution = new DistanceToNearestOne();
        CommonUtils.print(solution.updateMatrix(mat));
    }
}
