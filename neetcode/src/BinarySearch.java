public class BinarySearch {

    public int find(int[] arr, int target) {
        int n = arr.length - 1;
        int low = 0;
        int high = n;

        while (high > low) {
            int mid = (high + low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] arr = new int[] {-1,0,3,5,9,12};
        int target = 9;

        // expected result = 4
        int index = solution.find(arr, target);
        System.out.println("The target is present at index "+ index);
    }
}
