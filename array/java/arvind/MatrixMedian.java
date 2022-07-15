package arvind;

public class MatrixMedian {

    public int findMedian(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int medianIndex = m * n;

        int target = 9;
        // find number of elements lower or equal to 9
        int noLess = findNoElementsLowerThanX(target, arr);

        return -1;
    }

    private int findNoElementsLowerThanX(int target, int[][] arr) {
        int no = 0;

        for (int[] a: arr) {
            int low = 0;
            int high = a.length - 1;

            while (high > low) {
                int mid = (low + high) / 2;

                if (a[mid] == target && a[mid+1])
            }
        }

        return no;
    }

    public static void main(String[] args) {
        MatrixMedian solution = new MatrixMedian();
        int[][] arr = new int[][] {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        int median = solution.findMedian(arr);
        System.out.println("Median value is "+ median);

    }
}
