package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public List<String> findPath(int[][] arr) {
        List<String> result = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;
        int[][] visited = new int[m][n];
        findPath(0, 0, m, n, arr, "", visited, result);
        return result;
    }

    private void findPath(int i, int j, int m, int n, int[][] arr, String res, int[][] visited, List<String> result) {
        if (i == m-1 && j == n-1) {
            result.add(res);
            return;
        }

        if (isSafe(i, j, m, n, arr, visited)) {
            visited[i][j] = 1;
            // go up right down left
            findPath(i-1, j, m, n, arr, res + "U", visited, result);
            findPath(i, j+1, m, n, arr, res + "R", visited, result);
            findPath(i+1, j, m, n, arr, res + "D", visited, result);
            findPath(i, j-1, m, n, arr, res + "L", visited, result);
            // backtrack
            visited[i][j] = 0;
        }

    }

    private boolean isSafe(int i, int j, int m, int n, int[][] arr, int[][] visited) {
        if (i < 0 || i >=m || j < 0 || j >=n)
            return false;
        if (arr[i][j] == 0)
            return false;
        if (visited[i][j] == 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        RatMaze solution = new RatMaze();
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        List<String> paths = solution.findPath(arr);
        System.out.println(paths);
    }
}
