public class PrintMatrixInDiagonalOrder {
    void diagonalOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 1 && m > 1){
            for (int i = 0; i<m; i++){
                System.out.println(matrix[i][0]);
            }
            return;
        }
        int i = 0;
        int j = 0;
        int J = 1;
        while (i != m-1 || j != n){
            System.out.print(matrix[i][j]+" ");
            i -= 1;
            j += 1;
            if ((i<0 && j >= m) || (j >= n)){
                System.out.println();
                i = m-1;
                j = J;
                J = J+1;
            }else if(i<0){
                System.out.println();
                i = j;
                j = 0;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        PrintMatrixInDiagonalOrder pd = new PrintMatrixInDiagonalOrder();
        pd.diagonalOrder(matrix);
    }
}
 