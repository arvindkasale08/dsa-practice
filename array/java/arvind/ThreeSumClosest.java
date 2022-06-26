package arvind;

import java.util.Arrays;

public class ThreeSumClosest {

    public int closestTripletSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int result = Integer.MAX_VALUE;

        for (int i=0; i<n-2; i++) {
            int low = i+1;
            int high = n-1;

            while (low < high) {
                int currentResult = arr[low] + arr[i] + arr[high];
                if (Math.abs(target-currentResult) < Math.abs(result)){
                    result = target-currentResult;
                }

                if (result == 0)
                    break;

                if (currentResult > target) {
                    high-=1;
                } else {
                    low+=1;
                }

            }
        }
        return target - result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] arr = new int[] {0, 0, 0};
        int target = 1;
        int closestSum = threeSumClosest.closestTripletSum(arr, target);
        System.out.println("Closest sum is "+ closestSum);
    }
}
