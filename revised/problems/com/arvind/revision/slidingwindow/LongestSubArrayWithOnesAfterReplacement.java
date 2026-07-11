package com.arvind.revision.slidingwindow;

public class LongestSubArrayWithOnesAfterReplacement {

    public int longestOnes(int[] nums, int k) {
        int windowSize = Integer.MIN_VALUE;
        int l = 0;
        int noOfReplacements = 0;

        for (int r=0; r<nums.length; r++) {
            if (nums[r] == 1) {
                windowSize = Math.max(windowSize, r-l+1);
            } else {
                // invalid window move
                noOfReplacements +=1;
                while (noOfReplacements > k) {
                    if (nums[l] == 0) {
                        noOfReplacements -= 1;
                    }
                    l++;
                }
                // now window should be valid
                windowSize = Math.max(windowSize, r-l+1);
            }
        }

        return windowSize == Integer.MIN_VALUE ? 0 : windowSize;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int[] arr2 = new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int[] arr3 = new int[] {1, 1, 1, 1, 1};
        int[] arr4 = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 2;
        LongestSubArrayWithOnesAfterReplacement solution = new LongestSubArrayWithOnesAfterReplacement();
        System.out.println(solution.longestOnes(arr4, 3));
    }
}
