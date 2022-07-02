public class SetMatrixZeroes {
    void setZero(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = false;
        for (int i = 0; i<m; i++){
            if (matrix[i][0] == 0)
                col = true;
            for (int j = 0; j<n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m-1; i>-1; i--){
            for (int j = n-1; j>0; j--){
                if (matrix[i][0] != 0 || matrix[0][j] != 0){
                    matrix[i][j] = 0;
                }
                if (col)
                    matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1},{0}};
        SetMatrixZeroes smz = new SetMatrixZeroes();
        smz.setZero(matrix);
        for (int i =0; i<matrix.length; i++){
            for (int ele : matrix[i]){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
