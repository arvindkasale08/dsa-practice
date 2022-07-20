package arvind;

public class KSmallestElementSortedArray {

    public int findKthElement(int[] arr1, int[] arr2, int k) {
        int low = 0;
        int high = 1000000;

        while (low <= high) {
            int mid = (low + high) / 2;
            int noLessThanMid = totalLessThanX(arr1, arr2, mid);
            if (noLessThanMid == k - 1) {
                return mid;
            }
            if (noLessThanMid > k-1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int totalLessThanX(int[] arr1, int[] arr2, int x) {
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

    public static void main(String[] args) {
        KSmallestElementSortedArray solution = new KSmallestElementSortedArray();
        int[] arr1 = new int[] {1, 1000};
        int[] arr2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 4;
        // expected answer = 6
        int expectedAnswer = solution.findKthElement(arr1, arr2, k);
        System.out.println("EXpected answer "+ expectedAnswer);
    }
}
