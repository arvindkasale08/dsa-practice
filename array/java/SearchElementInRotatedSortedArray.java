public class SearchElementInRotatedSortedArray {
    
    int searchElementInRotatedSortedArray(int arr[], int start, int end, int position)
    {
        if (start > end){
            return -1;
        }
 
        int mid = (start + end) / 2;
        if (arr[mid] == position){
            return mid;
        }
 
        if (arr[start] <= arr[mid]) {
            if (position >= arr[start] && position <= arr[mid]){
                return searchElementInRotatedSortedArray(arr, start, mid - 1, position);
            }
            return searchElementInRotatedSortedArray(arr, mid + 1, end, position);
        }
 
        if (position >= arr[mid] && position <= arr[end]){
            return searchElementInRotatedSortedArray(arr, mid + 1, end, position);
        }
 
        return searchElementInRotatedSortedArray(arr, start, mid - 1, position);
    }

    public static void main(String args[])
    {
        int arr[] = { 5, 6, 7, 1, 2, 3, 4,};
        int size = arr.length;
        int target = 3;

        SearchElementInRotatedSortedArray seira = new SearchElementInRotatedSortedArray();
        int position = seira.searchElementInRotatedSortedArray(arr, 0, size - 1, target);
        System.out.println("Position: " + position);
        
    }
}