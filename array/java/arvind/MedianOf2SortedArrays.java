package arvind;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {
        MedianOf2SortedArrays solution = new MedianOf2SortedArrays();
        int[] arr1 = new int[] {1, 3};
        int[] arr2 = new int[] {2};

        // expected result = 3 + 4 / 2 = 3.5
        String median = solution.solve(arr1, arr2);
        System.out.println("Median is "+ median);

    }

    public String solve(int[] arr1, int[] arr2) {
            int n = arr1.length + arr2.length;
            int medianIndex = n % 2 == 0 ? (n / 2 - 1 ): (n / 2);
            boolean isEven = n % 2 == 0;

            int low = 0;
            int high = 100000000;

            while (low <= high) {
                int mid = (low + high) / 2;
                int noLess = numLessThanMid(arr1, arr2, mid);

                if (noLess <= medianIndex) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            String result = isEven ? String. format("%.1f", (float)(low + high) / 2.0) : String.format("%.1f", low/1.0);

            return result;
    }

    public int numLessThanMid(int[] arr1, int[] arr2, int x) {
        int nums = 0;

        nums += bs(arr1, x);
        nums += bs(arr2, x);

        return nums;
    }

    private int bs(int[] arr1, int x) {
        // binary search in 1
        int nums = 0;
        int low = 0, high = arr1.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr1[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        nums += low;
        return nums;
    }
}
