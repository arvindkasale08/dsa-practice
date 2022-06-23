package arvind;

public class BinarySearch {

    public int find(int start, int end, int[] arr, int target) {
        if (end < start) {
            return -1;
        }
        int mid = end - (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return find(start, mid - 1, arr, target);
        } else {
            return find(mid + 1, end, arr, target);
        }
    }

    public int find(int[] arr, int target) {
        int start = 0, end = arr.length - 1;


        while (end >= start) {
            int mid = end - (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[] {2, 3, 5, 9, 10, 11};
        int target = 2;
        int result = binarySearch.find(0, arr.length-1 , arr, target);
        System.out.println("Binary search output is "+ result);
        int result2 = binarySearch.find(arr, target);
        System.out.println("Binary search output is "+ result2);
    }
}
