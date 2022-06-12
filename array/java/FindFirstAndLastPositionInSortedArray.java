public class FindFirstAndLastPositionInSortedArray {
    public static int firstPosition(int arr[], int start, int end, int target, int size)
    {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || target > arr[mid - 1]) && arr[mid] == target){
                return mid;
            }else if (target > arr[mid]){
                return firstPosition(arr, (mid + 1), end, target, size);
            }else {
                return firstPosition(arr, start, (mid - 1), target, size);
            }
        }
        return -1;
    }

    public static int last(int arr[], int start, int end, int target, int size){
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if ((mid == size - 1 || target < arr[mid + 1]) && arr[mid] == target){
                return mid;
            }else if (target < arr[mid]){
                return last(arr, start, (mid - 1), target, size);
            }else {
                return last(arr, (mid + 1), end, target, size);
            }
        }
        return -1;
    }
 
    public static void main(String[] args){
        int arr[] = { 1, 1, 1, 2, 3, 4, 4, 5 };
        int size = arr.length;
        int target = 4;
        System.out.println("First Position: " + firstPosition(arr, 0, size - 1, target, size));
        System.out.println("Last Position: " + last(arr, 0, size - 1, target, size));
    }
}