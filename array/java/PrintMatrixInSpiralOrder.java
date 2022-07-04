public class PrintMatrixInSpiralOrder {
    void spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0;
        int l = 0;
        while (k<m && l<n) {
            for (int i = l; i<n; i++){
                System.out.println(matrix[k][i]);
            }
            k+=1;
            for (int i = k; i<m; i++){
                System.out.println(matrix[i][n-1]);
            }
            n -=1;
            if (k<m){
                for (int i = n-1; i>l-1;i--){
                    System.out.println(matrix[m-1][i]);
                }
                m-=1;
            }
            if (l<n){
                for (int i = m-1; i >k-1; i--){
                    System.out.println(matrix[i][l]);
                }
                l +=1;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6,},{7,8,9,}};
        PrintMatrixInSpiralOrder pm = new PrintMatrixInSpiralOrder();
        pm.spiralOrder(matrix);
    }
}
