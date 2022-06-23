

public class MaxConsecutiveOne {
    

    public int CountMaxOne(int arr[]){

        int count = 0 , max_count = 0 ;

        for(int i = 0 ; i < arr.length ; i++){
                
            if(arr[i] == 1){
                count++;
            }
            max_count = Math.max(count , max_count) ;

            if(arr[i] == 0){
                count = 0 ;
            }
            
        }
        return max_count;
    }

    public static void main(String args[]){

        MaxConsecutiveOne m = new MaxConsecutiveOne();
        int[] arr = new int[]{1 , 1 , 1 , 0 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 0 , 0 , 0 , 0 , 1 , 1 , 0 };

        // To Print the max number of 1 count in the array . 
        System.out.print(m.CountMaxOne(arr));

    }
}
