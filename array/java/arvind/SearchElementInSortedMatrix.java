package arvind;

public class SearchElementInSortedMatrix {


    public boolean containsBS(int[][] arr, int target) {
        // do a binary search
        for (int[] a : arr) {
            int low = 0, high = a.length -1;
            while (high >= low) {
                int mid = (low + high) / 2;

                if (a[mid] == target) return true;
                if (a[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
    public boolean containsBF(int[][] arr, int target) {
        // do a linear search for the element
        for (int[] a : arr) {
            for (int i=0; i<a.length; i++) {
                if (a[i] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchElementInSortedMatrix matrix = new SearchElementInSortedMatrix();
        int target = 25;
        int[][] arr = new int[][] {
                { 10, 20, 30, 40},
                { 15, 25, 36, 46},
                { 27, 29, 37, 48},
                { 32, 33, 39, 50}
        };
        boolean result = matrix.containsBF(arr, target);
        boolean result2 = matrix.containsBS(arr, target);
        System.out.println("Result is "+ result);
        System.out.println("Result2 is "+ result2);
    }
}
