import java.util.Arrays;

public class MinimumDifferenceHighestAndLowestKScores {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i=0; i < n - k+1; i++) {
            res = Math.min(res, (nums[i+k-1] - nums[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumDifferenceHighestAndLowestKScores solution = new MinimumDifferenceHighestAndLowestKScores();
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int result = solution.minimumDifference(nums, k);
        System.out.println(result);
    }
}
