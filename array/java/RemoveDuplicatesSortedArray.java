public class RemoveDuplicatesSortedArray{
    int removeDuplicatesSortedArray(int[] arr){
        if (arr.length == 0 || arr.length == 1){
            return arr.length;
        }

        int j = 0;
        for (int i = 0; i<arr.length-1; i++){
            if (arr[i] != arr[i+1]){
                arr[j] = arr[i];
                j++;
            }
        }

        arr[j] = arr[arr.length-1];
        j++;
        return j;
    }
    public static void main(String[] args){
        int arr[] = {1,1,2,2,5};
        RemoveDuplicatesSortedArray rda = new RemoveDuplicatesSortedArray();
        int size = rda.removeDuplicatesSortedArray(arr);
        for (int i = 0; i<size; i++){
            System.out.println(arr[i]);
        }
    }
}