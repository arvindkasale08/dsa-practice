package arvind;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstAndLastInSortedArray {

    // TC: O(n)
    public Integer[] findFirstAndLastLinear(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>(2);
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] == target && arr[i - 1] != target) || (arr[i] == target && arr[i + 1] != target)) {
                result.add(i);
            }
        }
        return result.toArray(new Integer[2]);
    }

    // TC: O(log n) making use of sorted nature of the question
    public int findFirst(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        if (low > high) {
            return -1; // not found
        }

        while (low <= high ) {
            int mid = high - (high - low) / 2;

            if (arr[mid] == target && (mid == 0 || arr[mid - 1] != target)) {
                return mid;
            }
            if (arr[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    // TC: O(log n) making use of sorted nature this time lets use recursion
    public int findLast(int[] arr, int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == arr.length - 1 || target < arr[mid + 1]) && arr[mid] == target){
                return mid;
            }
            if (arr[mid] <= target) {
                return findLast(arr, target, mid+1, high);
            }
            return findLast(arr, target, low, mid-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastInSortedArray obj = new FindFirstAndLastInSortedArray();
        int target = 2;
        int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 7, 7, 9};
        Integer[] result = obj.findFirstAndLastLinear(arr, target);
        System.out.println("Result using linear search is ");
        obj.display(result);

        int target2 = 2;
        int first = obj.findFirst(arr, target);

        int target3 = 2;
        int last = obj.findLast(arr, target, 0, arr.length - 1);

        System.out.println("Result is: first="+ first+ " last= "+ last);
    }

    private void display(Integer[] arr) {
        for (Integer a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }
}
