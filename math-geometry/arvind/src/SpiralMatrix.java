import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int l = 0;
        int t = 0;
        int b = matrix.length;
        int r = matrix[0].length;

        while (l < r && t < b) {

            for (int i=l; i<r; i++) {
                result.add(matrix[t][i]);
            }
            t += 1;

            for (int i=t; i<b; i++) {
                result.add(matrix[i][r-1]);
            }
            r-=1;

            if (t < b) {
                for (int i = r - 1; i >= l; i--) {
                    result.add(matrix[b - 1][i]);
                }
            }
            b -=1;

            if (l < r) {
                for (int i = b - 1; i >= t; i--) {
                    result.add(matrix[i][l]);
                }
            }
            l+= 1;
        }


        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println(result);
    }
}
