package arvind.neetcode;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int l=0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        for (int r=0; r<nums.length; r++) {
            sum += nums[r];
            if (sum >= target) {
                size = Math.min(size, r-l+1);
            }
            while (sum > target) {
                sum -= nums[l];
                l++;
                if (sum > target) {
                    size = Math.min(size, r-l+1);
                }
            }

        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2, 3};
        int target = 6;
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int result = solution.minSubArrayLen(target, nums);
        System.out.println(result);
    }
}
