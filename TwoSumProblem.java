import java.util.HashMap;

public class TwoSumProblem {
    
    // This is our bruteforce approach  -- Time complexity O(n^2)
    public static int[] bruteforce (int[] arr , int target){
        
        int[] a = new int[2];
         
        // 1st loop will always go till the n - 1 index as the 2nd loop will always one head of this loop  . 
        for(int i = 0; i < (arr.length - 1) ; i++){

            // 2nd loop will always start 1 element ahead of the previous loop as to avoid same element case .
            for(int j = (i + 1) ; j < arr.length ; j++){

                if(arr[i] + arr[j] == target){
                 a[0] = j;
                 a[1] = i;
                }
            }    
        }
        return a ;
    }

    // Now we will use O(n) extra space to Optimize the solution  ( Space Time Trade Off ) 

    public static int[] HashMapSolution(int[] arr , int target){

        int[] ans = new int[2];

        // Now we wil create one Hash Map data structure to store the elements in it . 
        HashMap<Integer , Integer > mp = new HashMap<Integer , Integer >();

        for( int i = 0 ; i < arr.length ; i++){

            // So , First we are checking in the map not putting  as so we don't have to check for the same pair condition 
            if(mp.containsKey(target - arr[i])){

                ans[0] = i;
                ans[1] = mp.get(target - arr[i]);               // Using the key value property of the map we will find the given index of the another pair  
                break;                                          // break out of the immediate loop running as we get the pair
            }
            mp.put(arr[i] , i );

        }
        return ans;
    }
 
    public static void main(String args[]){

        int arr[] = {1,2,3,4,2};
        int target = 7;
        int[] ans  = bruteforce(arr , target);

        System.out.println("Bruteforce answer 1st: "+ans[0]+" 2nd :"+ans[1]);

        ans  = HashMapSolution(arr , target);

        System.out.print("HashMap answer 1st: "+ans[0]+" 2nd :"+ans[1]);
    }
}
