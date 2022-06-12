public class BinarySearch {
    int binarySearch(int start, int end, int[] arr, int target){
        
        if (end<start){
            return -1;
        }

        int mid = (start+end)/2;
        
        if (arr[mid] == target){
            return mid;
        }

        if (arr[mid]<target){
            return binarySearch(mid+1, end, arr, target);
        }
        
        return binarySearch(start, mid-1, arr, target);
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6};
        int target = 3;
        BinarySearch bs = new BinarySearch();
        int position = bs.binarySearch(0, arr.length-1, arr, target);
        System.out.println("Position of "+target+" is "+position);
    }    
}
