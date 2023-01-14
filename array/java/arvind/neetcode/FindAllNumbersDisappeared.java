package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // do a inplace sorting as we have elements from 1 to n;
        List<Integer> result = new ArrayList<>();


        for (int i=0; i<nums.length; i++) {
            int idx = nums[i] - 1;
            if (nums[idx] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
                i--;
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (i+1 != nums[i]) {
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappeared solution = new FindAllNumbersDisappeared();
        List<Integer> result = solution.findDisappearedNumbers(nums);
        System.out.println(result);
    }
}
