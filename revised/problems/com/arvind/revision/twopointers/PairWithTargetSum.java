package com.arvind.revision.twopointers;

public class PairWithTargetSum {

    public int[] search(int[] arr, int targetSum) {
        // TODO: Write your code here
        int left = 0;
        int right = arr.length - 1;
        int[] ans = new int[2];
        while (left < right) {
            int calculatedSum = arr[left] + arr[right];
            if (calculatedSum == targetSum) {
                ans[0] = left;
                ans[1] = right;
                return ans;
            } else if (calculatedSum > targetSum) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] { -1, -1 };


    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 6};
        int target = 6;
        PairWithTargetSum solution = new PairWithTargetSum();
        int[] result = solution.search(arr, target);
        System.out.println("Answer is index: "+ result[0] + ", " + result[1]);
    }
}
