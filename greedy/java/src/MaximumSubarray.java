public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int prev = nums[0];
		int maxSoFar = nums[0];
		for (int i=1; i<nums.length; i++) {
			prev = Math.max(nums[i], nums[i] + prev);
			maxSoFar = Math.max(prev, maxSoFar);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		MaximumSubarray solution = new MaximumSubarray();
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		int sum = solution.maxSubArray(nums);
		System.out.println(sum);
	}
}
