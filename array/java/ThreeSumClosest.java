import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosestBruteForce(int arr[], int target){
        int closestSum = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length ; i++) {
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){
                    if (Math.abs(target - closestSum) > Math.abs(target - (arr[i] + arr[j] + arr[k]))){
                        closestSum = (arr[i] + arr[j] + arr[k]);
                    }
                } 
            }
        }
        return closestSum;
    }

    int threeSumClosest(int arr[], int target){
        Arrays.sort(arr);
        long closestSum = Integer.MAX_VALUE;
 
        for (int i = 0; i < arr.length - 2; i++){
            int ptr1 = i + 1, ptr2 = arr.length - 1;
            while (ptr1 < ptr2){
                int sum = arr[i] + arr[ptr1] + arr[ptr2];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }
                if (sum > target){
                    ptr2--;
                }else{
                    ptr1++;
                }
            }
        }
        return (int)closestSum;
    }

    public static void main(String[] args){
        ThreeSumClosest ts = new ThreeSumClosest();
        int arr[] = {1,5,3,4,2};
        int target = 13;
        int ans = ts.threeSumClosestBruteForce(arr, target);
        System.out.println("Three sum closest: "+ans);

        ans = ts.threeSumClosest(arr, target);
        System.out.println("Three sum closest: "+ans);

    }
}
