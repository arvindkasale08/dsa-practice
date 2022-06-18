public class FindUniqueElementInSortedArrayWhereEveryOtherElementOccursTwice {
    public int singleNonDuplicate(int[] arr) {
        int first = 0, last = arr.length-1;
        if(last == 0){
            return arr[0];
        }
        while(first<=last){
            if(arr[first] != arr[first+1]){
            return arr[first];
            }else{
                first = first + 2;
            }
            if(arr[last] != arr[last-1]){
                return arr[last];
            }else{
                last = last - 2;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] arr = {1,1,2,3,3};
        FindUniqueElementInSortedArrayWhereEveryOtherElementOccursTwice f = new FindUniqueElementInSortedArrayWhereEveryOtherElementOccursTwice(); 
        int ele = f.singleNonDuplicate(arr);
        System.out.println("ele: "+ele);
    }
}

