package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintMatrixDiagonals {

    public List<Integer> print(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int m = arr.length;
        int n = arr[0].length;

        for (int k=0; k<= n-1; k++) {
            int i=0;
            int j=k;
            while (j>=0) {
                result.add(arr[i][j]);
                i+=1;
                j-=1;
            }
        }

        for (int k=1; k <= m-1; k++) {
            int i=k;
            int j=n-1;

            while (i<= m-1) {
                result.add(arr[i][j]);
                i+=1;
                j-=1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrintMatrixDiagonals obj = new PrintMatrixDiagonals();
        int[][] arr = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = obj.print(arr);
        System.out.println(result);
    }
}
