package arvind.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    public List<List<String>> solve(int n) {
        char[][] board = new char[n][n];
        // initialize board
        for (int i=0; i< n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<char[][]> boards = new ArrayList<>();
        // go each row

        solve(0, n, board, boards);

        return null;
    }

    private void solve(int i, int n, char[][] board, List<char[][]> boards) {
        if (i == n) {
            boards.add(Arrays.stream(board).map(chars -> chars.clone()).toArray(char[][]::new));
            return;
        }

        // for each column on a row
        for (int j=0; j<n; j++) {
            if (isSafe(i, j, n, board)) {
                board[i][j] = 'Q';
                solve(i+1, n, board, boards);
                board[i][j] = '.';
            }
        }
    }

    private boolean isSafe(int i, int j, int n, char[][] board) {
        int I= i, J= j;
        while (i >=0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
        }
        //reset values
        i = I; j = J;
        while (i >=0 && j>=0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }

        i = I; j = J;
        while (i >=0 && j<n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen solution = new NQueen();
        int n = 4;
        List<List<String>> result = solution.solve(n);
        System.out.println(result);
    }
}
