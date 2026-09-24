package com.arvind.revision.pod;

public class SmallestWithDigitSum {

    public int smallestIndex(int[] nums) {
        int ans = -1;

        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            int r = nums[i];
            while (r > 0) {
                sum += r % 10;
                r = r /10;
            }
            System.out.println("Sum at index i=" + i + "is " + sum);
            if (i == sum) {
                return i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {123, 10, 11};
        SmallestWithDigitSum solution = new SmallestWithDigitSum();
        System.out.println(solution.smallestIndex(nums));
    }
}
