package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateImage {

    public int[][] solve(int[][] arr) {
        int n = arr.length;
        // transpose matrix
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // reverse the matrix
        for (int[] a : arr) {
            for (int i=0; i< n/2; i++) {
                int temp = a[i];
                a[i] = a[n-1-i];
                a[n-1-i] = temp;
            }
        }

        return arr;
    }

    public void print(int[][] arr) {
        for (int[] a : arr) {
            for (int x : a) {
                System.out.print(x+ " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        RotateImage image = new RotateImage();
        int[][] arr = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        image.print(arr);
        System.out.println("Answer is :");
        int[][] result = image.solve(arr);
        image.print(result);

    }
}
