package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    private boolean isSafe(char[][] board, int i, int j, int n) {
        int I = i, J = j;

        // check north
        while (i>=0) {
            if (board[i][j]=='Q') return false;
            i--;
        }
        // reset i and j
        i = I;  j = J;
        // check north west
        while (i >=0 & j >=0) {
            if (board[i][j]=='Q') return false;
            i--;
            j--;
        }
        // reset i and j
        i = I; j = J;
        // check north east
        while (i >=0 && j<=n-1) {
            if (board[i][j]=='Q') return false;
            i--;
            j++;
        }
        return true;
    }
    public boolean placeQueens(char[][] board, int i, int n, List<char[][]> boardCombinations) {
        if (i == n) {
            boardCombinations.add(Arrays.stream(board).map(x -> x.clone()).toArray(char[][]::new));
            return true;
        }
        for (int j = 0; j<n; j++) {
            if (isSafe(board, i, j, n)) {
                // add Q to board location
                board[i][j] = 'Q';
                // recurse
                placeQueens(board, i+1, n, boardCombinations);
                // remove Q from board lcoation
                board[i][j] = '.';
            }
        }
        return false;
    }

    private static void initializeBoard(char[][] board) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
    }

    private static void display(char[][] board) {
        int n = board.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("####################################");
    }

    public static void main(String[] args) {
        int n = 8;
        char[][] board = new char[n][n];
        initializeBoard(board);
        List<char[][]> boardCombinations = new ArrayList<>();
        NQueen nQueen = new NQueen();
        nQueen.placeQueens(board, 0, n, boardCombinations);
        System.out.println(boardCombinations.size() + " Possibilities");
        boardCombinations.stream().forEach(chars -> display(chars));
    }
}
