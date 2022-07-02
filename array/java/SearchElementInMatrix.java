public class SearchElementInMatrix {
    boolean searchELement(int[][] matrix, int val){
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while(i<m){
            if (matrix[i][j] == val){
                return true;
            }
            if (matrix[i][j]<val){
                i++;
            }else{
                j--;
            }
            if (i == m || j < 0){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{{10,20,30,40},{15,25,36,46},{27, 29, 37, 48},{32, 33, 39, 50}};
        int val = 32;
        SearchElementInMatrix se = new SearchElementInMatrix();
        System.out.println(se.searchELement(matrix, val));
    }
}
