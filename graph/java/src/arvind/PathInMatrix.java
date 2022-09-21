package arvind;

import java.util.LinkedList;
import java.util.Queue;

public class PathInMatrix {

    /**
     * Do a bfs till m-1, n-1 cell. If possible then ok.
     * @param matrix
     * @param m
     * @param n
     * @return
     */
    public boolean hasPath(int[][] matrix, int m, int n) {
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        if (matrix[0][0] == -1)
            return false;
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        // DLRU
        int[] DIR_I = {1, 0, 0, -1};
        int[] DIR_J = {0, -1, 1, 0};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int I = cell[0];
            int J = cell[1];

            if (I == m-1 && J == n-1) {
                return true;
            }

            for (int k=0; k<4; k++) {
                int new_i = I + DIR_I[k];
                int new_j = J + DIR_J[k];

                if (new_i > -1 && new_i < m && new_j > -1 && new_j < n && matrix[new_i][new_j] == 0 && visited[new_i][new_j] == 0) {
                    visited[new_i][new_j] = 1;
                    queue.offer(new int[] {new_i, new_j});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PathInMatrix solution = new PathInMatrix();
        int[][] matrix = {
                {0, 0, 0, -1, 0},
                {-1, 0, 0, -1, -1},
                {0, 0, 0, -1, 0},
                {-1, 0, 0, 0, 0},
                {0, 0, -1, 0, 0},
        };
        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasPath = solution.hasPath(matrix, m, n);
        if (hasPath) {
            System.out.println("The matrix has path.");
        } else {
            System.out.println("The matrix has no path.");
        }
    }
}
