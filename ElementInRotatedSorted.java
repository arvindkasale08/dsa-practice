public class ElementInRotatedSorted {
    
    public static int RecursiveBinarySearch(int[] input , int target ,  int low , int high){

            int mid = low + (high - low) / 2 ;

            if(input[mid] == target)
                return mid;

            if(low > high)
                return -1;

            else if(input[low] <= input[mid]){

                if(input[low] <= target && input[mid] > target)
                    return RecursiveBinarySearch( input , target , low , mid - 1 );
                
                else return RecursiveBinarySearch( input , target , mid + 1 , high);       
            }
            
            else {

                if(input[mid] < target && input[high] >= target){
                    return RecursiveBinarySearch( input , target , mid + 1 , high);
                }
                else return RecursiveBinarySearch( input , target , low , mid - 1 );
            }
    }


    // This is the implementation of BinarySearch in iterative manner 
    public static int IterativeBinarySearch(int[] input , int target){

        int low = 0 , high = input.length - 1 ;

        while( low <= high){

            int mid = low + (high - low) / 2 ;

            if(input[mid] == target)
                return mid;

            else if(input[low] <= input[mid]){

                if(input[low] <= target && input[mid] > target)
                        high = mid - 1 ;
                
                else low = mid + 1 ;       
            }
            
            else {

                if(input[mid] < target && input[high] >= target){
                    low = mid + 1 ; 
                }
                else high = mid + 1 ; 
            }

        }

        return -1;
    }

    public static void main(String args[]){

        int[] input = new  int[]{ 4 , 5 , 6 , 7 , 0 , 1 , 2 } ;
        int target = 0 ; 

        System.out.println("Using Iteraive binary search index is : "+IterativeBinarySearch(input , target ));

        System.out.println("Using Recursive binary search index is : "+RecursiveBinarySearch(input , target , 0 , input.length - 1 ));
    }
}
