package arvind;

/*
Kadane's Algorithm
 */
public class LargestSumSubarray {

    public int findMaxSumInSubarray(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int a : arr) {
            maxEndingHere += a;
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        LargestSumSubarray solution = new LargestSumSubarray();
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.findMaxSumInSubarray(arr);
        System.out.println("Maximum sum is "+ result);
    }
}
