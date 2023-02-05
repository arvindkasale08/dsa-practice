import java.util.Arrays;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        isFirstRowZero = true;
                        continue;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i == 0 && isFirstRowZero) {
                    matrix[0][j] = 0;
                }
                if (i != 0 && (matrix[i][0] == 0 || matrix[0][j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        SetMatrixZeroes solution = new SetMatrixZeroes();
        solution.setZeroes(matrix);

        for (int[] m: matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
