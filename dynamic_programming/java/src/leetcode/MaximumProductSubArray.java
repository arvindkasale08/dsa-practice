package leetcode;

public class MaximumProductSubArray {

	public int maxProduct(int[] nums) {
		int n = nums.length;
		int[] dpmax = new int[n];
		int[] dpmin = new int[n];
		dpmax[0] = nums[0];
		dpmin[0] = nums[0];

		for (int i=1; i<n; i++) {
			dpmax[i] = Math.max( Math.max(nums[i] * dpmax[i-1], nums[i] * dpmin[i-1]), nums[i]);
			dpmin[i] = Math.min( Math.min(nums[i] * dpmax[i-1], nums[i] * dpmin[i-1]), nums[i]);
		}
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			max = Math.max(max, dpmax[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, -2, 4};
		MaximumProductSubArray solution = new MaximumProductSubArray();
		int res = solution.maxProduct(nums);
		System.out.println(res);
	}
}
