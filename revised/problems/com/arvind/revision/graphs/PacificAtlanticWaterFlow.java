package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.*;

public class PacificAtlanticWaterFlow {

    private static final int[] DIR_I = {-1, 0, 1, 0};
    private static final int[] DIR_J = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] visitedPacific = new int[m][n];
        int[][] visitedAtlantic = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        // we will do bfs to see till where we can go from the pacific side
        for (int j=0; j<n; j++) {
            visitedPacific[0][j] = 1;
            queue.offer(new int[] {0, j});
        }
        for (int i=0; i<m; i++) {
            visitedPacific[i][0] = 1;
            queue.offer(new int[] {i, 0});
        }

        bfs(m, n, queue, heights, visitedPacific);

        // we will do bfs to see till where we can go from the atlantic side
        for (int j=0; j<n; j++) {
            visitedAtlantic[m-1][j] = 1;
            queue.offer(new int[] {m-1, j});
        }

        for (int i=0; i<m; i++) {
            visitedAtlantic[i][n-1] = 1;
            queue.offer(new int[] {i, n-1});
        }

        bfs(m, n, queue, heights, visitedAtlantic);

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visitedAtlantic[i][j] == 1 && visitedPacific[i][j] == 1) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int m, int n, Queue<int[]> queue, int[][] heights, int[][] visited) {
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int I = node[0];
            int J = node[1];

            for (int k=0; k<4; k++) {
                int newI = I + DIR_I[k];
                int newJ = J + DIR_J[k];

                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && heights[newI][newJ] >= heights[I][J]) {
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        CommonUtils.printListListInt(solution.pacificAtlantic(heights));
    }
}
