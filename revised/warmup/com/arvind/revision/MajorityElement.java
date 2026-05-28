package com.arvind.revision;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 1;
        int majElement = nums[0];

        for (int n : nums) {
            if (n == majElement) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majElement = n;
                    count = 1;
                }
            }
        }

        return majElement;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 2, 1, 1, 1, 2, 2};
        MajorityElement solution = new MajorityElement();
        System.out.println(solution.majorityElement(arr));
    }
}
