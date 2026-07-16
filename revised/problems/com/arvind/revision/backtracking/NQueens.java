package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        initializeBoard(board);
        List<char[][]> boards = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        solveNQueensInner(board, 0, n, boards);

        // transpose the board to result
        for (char[][] b : boards) {
            List<String> lst = new ArrayList<>();
            for (char[] c : b) {
                lst.add(String.valueOf(c));
            }
            result.add(lst);
        }
        return result;
    }

    private void solveNQueensInner(char[][] board, int i, int n, List<char[][]> boards) {
        if (i == n) {
            boards.add(Arrays.stream(board).map(char[]::clone).toArray(char[][]::new));
            return;
        }

        for (int j=0; j< board.length; j++) {
            if (isSafe(i, j, board)) {
                board[i][j] = 'Q';
                solveNQueensInner(board, i + 1, n, boards);
                board[i][j] = '.';
            }
        }
    }

    private boolean isSafe(int i, int j, char[][] board) {
        int I = i;
        int J = j;
        // look in north.
        while (I >= 0) {
            if (board[I][J] == 'Q') return false;
            I--;
        }
        I = i;
        J = j;

        // check north west
        while (I >= 0 && J >= 0) {
            if (board[I][J] == 'Q') return false;
            I--;
            J--;
        }
        I = i;
        J = j;

        // check north east
        while (I >= 0 && J <= board[0].length - 1) {
            if (board[I][J] == 'Q') return false;
            I--;
            J++;
        }

        return true;
    }

    private void initializeBoard(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i< m; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
    }

    public static void main(String[] args) {
        int N = 4;
        NQueens solution = new NQueens();
        CommonUtils.print(solution.solveNQueens(N));
    }
}
