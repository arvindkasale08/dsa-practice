package arvind;

public class LeftSideSmallerRightSideGreater {

    public int solve(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];

        for (int i=1; i< n; i++) {
            if (arr[i] > left[i-1]) {
                left[i] = arr[i];
            } else {
                left[i] = left[i-1];
            }
        }

        for (int i=n-1-1; i>=0; i--) {
            if (arr[i] < right[i+1]) {
                right[i] = arr[i];
            } else {
                right[i] = right[i+1];
            }
        }

        for (int i=1; i< n-1; i++) {
            if (arr[i] >= left[i] && arr[i] <= right[i]) {
                return arr[i];
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        LeftSideSmallerRightSideGreater lsrg = new LeftSideSmallerRightSideGreater();
        int[] arr = new int[] {4, 3, 2, 1, 5, 9, 8, 7};
        int result = lsrg.solve(arr);
        System.out.println("Result is "+ result);
    }
}
