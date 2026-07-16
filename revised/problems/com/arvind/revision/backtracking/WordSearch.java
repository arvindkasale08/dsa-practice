package com.arvind.revision.backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        char[] input = word.toCharArray();
        int index = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && board[i][j] == input[index]) {
                    visited[i][j] = 1;
                    if (dfs(board, i, j, input, index, visited)) return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] input, int index, int[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (index == input.length - 1) return true;
        int newIndex = index + 1;

        int[] DIR_I = new int[] {-1, 0, 1, 0};
        int[] DIR_J = new int[] {0, 1, 0, -1};

        for (int k = 0; k<4; k++) {
            int newI = i + DIR_I[k];
            int newJ = j + DIR_J[k];

            if (newI > -1 && newJ > -1 && newI < m && newJ < n && board[newI][newJ] == input[newIndex] && visited[newI][newJ] == 0) {
                visited[newI][newJ] = 1;
                if (dfs(board, newI, newJ, input, newIndex, visited)) return true;
                visited[newI][newJ] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        WordSearch solution = new WordSearch();
        System.out.println(solution.exist(board, word));
    }
}
