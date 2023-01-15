package arvind.neetcode;

import java.util.Arrays;
import java.util.HashMap;

public class SortColors {

    public void sortColorsSinglePass(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        for (int i=0; i<nums.length; i++) {

            if (nums[i] == 0) {
                if (l <= i) {
                    swap(nums, l, i);
                    l++;
                }
            } else if (nums[i] == 2) {
                if (i <= r) {
                    swap(nums, r, i);
                    r--;
                    i = i-1;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors2pass(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        int idx=0;
        int j=0;
        while (j < 3) {
            int count = hash.containsKey(j) ? hash.get(j): 0;
            for (int i=0; i< count; i++) {
               nums[idx] = j;
               idx++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        SortColors solution = new SortColors();
        solution.sortColorsSinglePass(nums);
        System.out.println(Arrays.toString(nums));
    }
}
