package arvind.neetcode;

import java.util.Arrays;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i=0; i<nums.length; i++) {
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex solution = new FindPivotIndex();
        int[] nums = {1, 2, 3};
        int index = solution.pivotIndex(nums);
        System.out.println(index);
    }
}
