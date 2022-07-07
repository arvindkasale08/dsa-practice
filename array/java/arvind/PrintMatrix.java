package arvind;

public class PrintMatrix {

    public void printSpiral(int[][] arr) {
        int t=0, l=0, r = arr[0].length; int b = arr.length;

        while (l < r && t < b) {
            for (int i = l; i< r; i++) {
                System.out.print(arr[t][i]+ " ");
            }
            t+=1;
            for (int i=t; i<b; i++) {
                System.out.print(arr[i][r-1]+ " ");
            }
            r-=1;

            if (t < b) {
                for (int i = r-1; i >= l; i--) {
                    System.out.print(arr[b - 1][i]+ " ");
                }
                b -= 1;
            }

            if (l < r) {
                for (int i=b-1; i >= t; i--) {
                    System.out.print(arr[i][l]+ " ");
                }
                l += 1;
            }

        }
    }

    public static void main(String[] args) {
        PrintMatrix pm = new PrintMatrix();
        int[][] arr = new int[][] { {1,2,3,4}, {5,6,7,8}, {9, 10, 11, 12}, {13,14,15,16} };
        pm.printSpiral(arr);
    }
}
