package com.arvind.revision.slidingwindow;

public class MaximumAverageSubarrayOfSize {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int l = 0;
        int r = 0;
        while (r < k) {
            sum += nums[r];
            r++;
        }
        double maxAvg = (double) sum / k;
        while (r < nums.length) {
            sum = sum + nums[r] - nums[l];
            maxAvg = Math.max(maxAvg, ((double) sum / k));
            l++;
            r++;
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        MaximumAverageSubarrayOfSize solution = new MaximumAverageSubarrayOfSize();
        System.out.println(solution.findMaxAverage(arr, k));
    }
}
