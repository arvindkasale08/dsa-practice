public class RotateImage {

    void rotateImage(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int j = 0; j < matrix.length; j++) {
            for(int i = 0; i < matrix[j].length / 2; i++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix[j].length - i - 1];
                matrix[j][matrix[j].length - i - 1] = temp;
            }
        }
    }

    int[][] rotateMatrix(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i<n/2; i++){
            for (int j = i; j<n-i-1; j++){
                int temp = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-j-1][n-j-1] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args){
        int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        RotateImage ri = new RotateImage();
        ri.rotateImage(matrix);
        for(int i = 0; i<matrix.length; i++){
            for(int ele : matrix[i]){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        int matrix_2[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        matrix_2 = ri.rotateMatrix(matrix_2);
        for(int i = 0; i<matrix_2.length; i++){
            for(int ele : matrix_2[i]){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
