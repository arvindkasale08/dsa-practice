package arvind;

import java.util.LinkedList;
import java.util.Queue;

public class LargestRegion {

    public int findLargestRegion(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int area = Integer.MIN_VALUE;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 1) {
                    visited[i][j] = 1;
                    area = Math.max(bfs(matrix, i, j, m, n, visited), area);
                }
            }
        }
        return area;
    }

    public int bfs(int[][] matrix, int i, int j, int m, int n, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        int[] DIR_I = {-1, -1, -1, 0, 1, 0, 1, 1};
        int[] DIR_J = {-1, 1, 0, -1, -1, 1, 0, 1};
        int area = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int I = cell[0];
            int J = cell[1];

            for (int k =0; k< 8; k++) {
                int new_I = I + DIR_I[k];
                int new_J = J + DIR_J[k];
                if (new_I > -1 && new_I < m && new_J > -1 && new_J < n && matrix[new_I][new_J] == 1 && visited[new_I][new_J] == 0) {
                    visited[new_I][new_J] = 1;
                    area += 1;
                    queue.offer(new int[] {new_I, new_J});
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        LargestRegion solution = new LargestRegion();
        int[][] matrix = new int[][] {
                {0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
        };

        // expected output is 6 as an island could be formed in 8 directions
        int area = solution.findLargestRegion(matrix);
        System.out.println(area);
    }
}
