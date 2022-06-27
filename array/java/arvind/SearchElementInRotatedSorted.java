package arvind;

public class SearchElementInRotatedSorted {

    public int find(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while (high >= low) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                if (arr[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchElementInRotatedSorted sorted = new SearchElementInRotatedSorted();
        int[] arr = new int[] {15, 17, 19, 21, 5, 9, 11};
        int target = 5;
        int result = sorted.find(arr, target);
        System.out.println("The target is present at index= "+ result);
    }
}
