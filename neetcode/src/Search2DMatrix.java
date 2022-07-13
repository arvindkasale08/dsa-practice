public class Search2DMatrix {

    public boolean search(int[][] arr, int target) {
        int row = findRow(arr, target);
        if (row == -1)
            return false;
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[row][mid]) {
                return true;
            }
            if (target < arr[row][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public int findRow(int[][] arr, int target) {
        int top = 0;
        int bottom = arr.length - 1;
        int m = arr.length;
        int n = arr[0].length;

        if (m == 1)
            return 0;

        while (bottom >= top) {
            int mid = (top + bottom) / 2;
            if ((n == 1 && arr[mid][0] == target) || (arr[mid][0] <= target && arr[mid][n-1] >= target)) {
                return mid;
            }
            if (arr[mid][0] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search2DMatrix solution = new Search2DMatrix();
        int[][] arr = new int[][] {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        /*int arr[][] = new int[][] {
                {1},
                {3}
        };*/
        int target = 223;
        boolean isPresent = solution.search(arr, target);
        System.out.println("The element exists " + isPresent);
    }
}
