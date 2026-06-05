package com.arvind.revision.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    public int searchTriplet(int[] arr, int targetSum) {
        // TODO: Write your code here
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        int closeSum = Integer.MAX_VALUE;
        for (int i=0 ; i< arr.length; i++) {
            int l= i+1;
            int r = arr.length-1;

            while (l < r) {
                int currSum = arr[i] + arr[l] + arr[r];
                int currDiff = Math.abs(targetSum - currSum);
                if (currSum >= targetSum) {
                    if (currDiff < minDiff) {
                        closeSum = currSum;
                        minDiff = currDiff;
                    } else if (currDiff == minDiff) {
                        closeSum = Math.min(currSum, closeSum);
                    }
                    r--;
                } else {
                    if (currDiff < minDiff) {
                        closeSum = currSum;
                        minDiff = currDiff;
                    } else if (currDiff == minDiff) {
                        closeSum = Math.min(currSum, closeSum);
                    }
                    l++;
                }
             }
        }
        return closeSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 1, 1, 2, 6};
        int[] arr1 = new int[] {-1, 2, 1, -4};
        int[] arr2 = new int[] {-3, -1, 1, 2};
        int target = 1;
        ThreeSumClosest solution = new ThreeSumClosest();
        int res = solution.searchTriplet(arr2, target);
        System.out.println(res);
    }
}
