package arvind;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public List<String> findPath(int[][] arr, int n) {
        List<String> results = new ArrayList<>();
        int[][] visited = new int[n][n];
        // arr, n, result string, i, j, results
        findPath(arr, n, "", 0, 0, results, visited);
        return results;
    }

    private boolean isSafe(int[][] arr, int n, int i, int j) {
        if (i < 0 || j < 0 || i > n-1 || j > n-1) {
            return false;
        }
        if (arr[i][j] == 0) {
            return false;
        }
        return true;
    }

    public void findPath(int[][] arr, int n, String res, int i, int j, List<String> results, int[][] visited) {
        if (i == n-1 && j == n-1 && isSafe(arr, n, i, j)) {
            results.add(res);
            return;
        }
        if (!isSafe(arr, n, i, j)) {
            return;
        }
        if (visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        // move in all directions
        findPath(arr, n, res + "D", i+1, j, results, visited); // down
        findPath(arr, n, res + "L", i, j-1, results, visited); // left
        findPath(arr, n, res + "R", i, j+1, results, visited); // right
        findPath(arr, n, res + "U", i-1, j, results, visited); // up
        visited[i][j] = 0;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[][] {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        RatMaze solution = new RatMaze();
        List<String> result = solution.findPath(arr, n);
        System.out.println(result);
    }
}
