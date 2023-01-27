import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            int targetSum = 0 - nums[i];

            while (l < r) {
                int indexSum = nums[l] + nums[r];
                if ( indexSum - targetSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
                if (indexSum - targetSum > 0) {
                    r -=1;
                } else {
                    l +=1;
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        ThreeSum solution = new ThreeSum();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
