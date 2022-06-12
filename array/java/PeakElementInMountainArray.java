public class PeakElementInMountainArray {
    
    int findPeakUtil(int arr[], int start, int end, int size){
        int mid = start + (end - start) / 2;

        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == size - 1 || arr[mid + 1] <= arr[mid]))
            return mid;
 
        else if (mid > 0 && arr[mid - 1] > arr[mid]){
            return findPeakUtil(arr, start, (mid - 1), size);
        }  
        return findPeakUtil(arr, (mid + 1), end, size);
    }

    public static void main(String[] args)
    {   
        PeakElementInMountainArray pema = new PeakElementInMountainArray();
        int arr[] = { 1, 2, 3, 4, 3, 2, 1 };
        int size = arr.length;
        int peak = pema.findPeakUtil(arr, 0, size - 1, size);
        System.out.println("Peak: " + peak);
    }
}