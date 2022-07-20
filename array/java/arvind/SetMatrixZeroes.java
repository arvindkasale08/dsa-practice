package arvind;

public class SetMatrixZeroes {

    public void display(int[][] arr) {
        for (int[] a : arr) {
            for (int x : a) {
                System.out.print(" "+ x);
            }
            System.out.println("");
        }
    }

    public void setMatrixZeroesExtraSpace(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[] rows = new int[m];
        int[] columns = new int[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 0) {
                    rows[i] = -1;
                    columns[j] = -1;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == -1 || columns[j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println("abcdef");
    }

    public void setMatrixZeroesBF(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        // O (n * m)
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == 0) {
                    markRowAsMinus1(arr, i);
                    markColumnAsMinus1(arr, j);
                }
            }
        }

        // O (n * m)
        // Iterate through the matrix and convert all -1s to 0s
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public void setMatrixZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        boolean col = false;
        for (int i=0; i<m; i++) {
                if (arr[i][0] == 0)
                    col = true;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for (int i= m-1; i>=0; i--) {
            for (int j= n-1; j>=0; j--) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    if (j != 0) {
                        arr[i][j] = 0;
                    }
                }
            }
            if (col) {
                arr[i][0] = 0;
            }
        }
    }

    public void markRowAsMinus1(int[][] arr, int i) {
        for (int j=0; j <arr[i].length; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public void markColumnAsMinus1(int[][] arr, int j) {
        for (int i=0; i <arr.length; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes solution = new SetMatrixZeroes();
        /*
        0 1 2 0
3 4 5 2
1 3 1 5
         */
        int[][] arr = new int[][] {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        // expected result in this case
        /*
          {1, 0, 1, 1}
          {0, 0, 0, 0}
          {1, 0, 1, 1}
         */
        solution.display(arr);
        solution.setMatrixZeroes(arr);
        solution.display(arr);
    }
}
