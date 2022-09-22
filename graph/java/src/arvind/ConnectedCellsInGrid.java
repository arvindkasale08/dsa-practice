package arvind;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedCellsInGrid {

    public int find(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int size = Integer.MIN_VALUE;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (visited[i][j] == 0 && matrix[i][j] == 1) {
                    size = Math.max(find(matrix, i, j, m, n, visited), size);
                    System.out.println(size);
                }
            }
        }
        return size;
    }

    public int find(int[][] matrix, int i, int j, int m, int n, int[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        visited[i][j] = 1;
        int size = 1;
        // N NE E SE S SW W NW
        int[] DIR_I = new int[] {-1, -1, 0, 1, 1, 1 ,0 , -1};
        int[] DIR_J = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int I = cell[0];
            int J = cell[1];
            visited[I][J] = 1;
            for (int k=0; k < 8; k++) {
                int new_I = I + DIR_I[k];
                int new_J = J + DIR_J[k];

                if (new_I < m && new_I > -1 && new_J < n && new_J > -1 && visited[new_I][new_J] == 0 && matrix[new_I][new_J] == 1 ) {
                    visited[new_I][new_J] = 1;
                    size+=1;
                    queue.offer(new int[] {new_I, new_J});
                }
            }

        }
        return size;
    }

    public static void main(String[] args) {
        ConnectedCellsInGrid solution = new ConnectedCellsInGrid();
        int[][] matrix = new int[][] {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        int sizeOfLargestIsland = solution.find(matrix);
        System.out.println(sizeOfLargestIsland);
    }
}
