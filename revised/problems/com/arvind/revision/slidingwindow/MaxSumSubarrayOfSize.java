package com.arvind.revision.slidingwindow;

public class MaxSumSubarrayOfSize {

    public int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int l = 0;
        int r = 0;
        // premove r and calculate the sum and put it in maxSum
        while (r < k) {
            maxSum += arr[r];
            r++;
        }
        int sum = maxSum;
        while (r < arr.length) {
            sum = sum - arr[l] + arr[r];
            maxSum = Math.max(maxSum, sum);
            l++;
            r++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 5, 1, 3, 2};
        int[] arr2 = new int[] {2, 3, 4, 1, 5};
        int k = 3;
        MaxSumSubarrayOfSize solution = new MaxSumSubarrayOfSize();
        System.out.println(solution.findMaxSumSubArray(2, arr2));
    }
}
