package arvind.neetcode;

import java.util.Arrays;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        int i = 1;
        boolean isGreater = true;
        while (i < nums.length) {
            if (isGreater) {
                if (nums[i] < nums[i-1]) {
                    swap(nums, i, i-1);
                }
            } else {
                if (nums[i] > nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }
            isGreater = !isGreater;
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        WiggleSort solution = new WiggleSort();
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
