package com.arvind.revision.graphs;

import com.arvind.revision.common.CommonUtils;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    private static final int[] DIR_I = {-1, 0, 1, 0};
    private static final int[] DIR_J = {0, 1, 0, -1};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i< m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0 && (i==0 || i==m-1 || j==0 || j == n-1)) {
                    visited[i][j] = 1;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        bfs(m, n, queue, board, visited);

        // mark visited as 0 rest as 1
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 1) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int m, int n, Queue<int[]> queue, char[][] board, int[][] visited) {

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            visited[i][j] = 1;

            for (int k=0; k<4; k++) {
                int newI = i + DIR_I[k];
                int newJ = j + DIR_J[k];
                if (newI > -1 && newI < m && newJ > -1 && newJ < n && visited[newI][newJ] == 0 && board[newI][newJ] == 'O') {
                    visited[newI][newJ] = 1;
                    queue.offer(new int[] {newI, newJ});
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'X', 'O'}
        };
        SurroundedRegions solution = new SurroundedRegions();
        solution.solve(board);
        CommonUtils.print(board);
    }
}
