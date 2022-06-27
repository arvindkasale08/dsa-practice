package arvind;

public class SearchInsertPosition {

    public int find(int[] arr, int target) {
        int n = arr.length;
        int high = n -1, low = 0;

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

        return low;
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] arr = new int[] {1, 3, 5, 6};
        int target = 8;
        int result = sip.find(arr, target);
        System.out.println("Result value is "+ result);
    }
}
