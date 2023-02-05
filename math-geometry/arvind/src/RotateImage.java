import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        // find the transpose of the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse the array rows
        for (int i=0; i<m; i++) {
            for (int j=0; j<n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImage solution = new RotateImage();
        solution.rotate(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
