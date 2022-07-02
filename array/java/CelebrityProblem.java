public class CelebrityProblem {
    int celebrityProblem(int[][] matrix){
        int n = matrix.length;
        int i = 0;
        int j = n-1;
        while(i<j){
            if (matrix[i][j] != 0){
                i++;
            }else{
                j--;
            }
        }
        for (int k = 0; k<n;k++){
            if (i != k && ((matrix[i][k] != 0) || matrix[k][i] == 0 ))
                return -1;
        }
        return i;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{ 0, 0, 1, 0 },{ 0, 0, 1, 0 },{ 0, 0, 0, 0 },{ 0, 0, 1, 0 }};
        CelebrityProblem cp = new CelebrityProblem();
        System.out.println(cp.celebrityProblem(matrix));
    }
}
