package arvind.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    public boolean findNQueen(char[][] board, int i, int n, List<char[][]> boards) {
        if (i == n) {
            boards.add(Arrays.stream(board).map(chars -> chars.clone()).toArray(char[][]::new));
            return true;
        }

        for (int j=0; j<n; j++) {
            if (isSafe(board, i, j, n)) {
                board[i][j] = 'Q';
                // next row me jaake same recurse
                findNQueen(board, i+1, n, boards);
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int i, int j, int n) {
        int I = i, J = j;
        // north
        while (i >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
        }
        i= I; j = J;
        // north west
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = I; j = J;
        // north east
        while (i >= 0  && j < n) {
            if (board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen solution = new NQueen();
        int n = 8;
        char[][] board = new char[n][n];
        List<char[][]> boards = new ArrayList<>();
        initializeBoard(board);
        solution.findNQueen(board, 0, n, boards);
        System.out.println("Number of boards "+ boards.size());
        boards.stream().forEach(chars -> display(chars));
    }

    private static void display(char[][] board) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("#########################");
    }
    private static void initializeBoard(char[][] board) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
    }
}
