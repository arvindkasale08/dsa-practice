import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IVSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n= nums.length;
        for (int i=0; i<n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j=i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j+1;
                int r = n-1;
                while (l < r) {
                    int targetNow = target - nums[i] - nums[j];
                    if (nums[l] + nums[r] == targetNow) {
                        // Found an entry;
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) {
                            l += 1;
                        }
                        while (l < r && nums[r] == nums[r-1]) {
                            r -= 1;
                        }
                    }
                    if (nums[l]+ nums[r] > targetNow) {
                        r -= 1;
                    } else {
                        l += 1;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IVSum solution = new IVSum();
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> result = solution.fourSum(nums, target);
        System.out.println(result);
    }
}
