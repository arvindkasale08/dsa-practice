package arvind;

public class MaxProductSubArray {

	public int findProduct(int[] nums) {
		int n = nums.length;
		int[] dpmin = new int[n];
		int[] dpmax = new int[n];
		dpmin[0] = nums[0];
		dpmax[0] = nums[0];

		for (int i=1; i<n; i++) {
			dpmax[i] = Math.max(Math.max(nums[i] * dpmax[i-1], nums[i] * dpmin[i-1]), nums[i]);
			dpmin[i] = Math.min(Math.min(nums[i] * dpmax[i-1], nums[i] * dpmin[i-1]), nums[i]);
		}

		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			max = Math.max(dpmax[i], max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2,3,-2,4, -2};
		MaxProductSubArray solution = new MaxProductSubArray();
		int result = solution.findProduct(nums);
		System.out.println(result);
	}
}
