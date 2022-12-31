public class MaxPointsFromCards {

	public int maxScore(int[] nums, int k) {
		int n = nums.length;
		int l = 0;
		int r = n - k - 1;

		int sum = 0;
		for (int i=r+1; i< n; i++) {
			sum += nums[i];
		}
		int maxSum = sum;
		r+=1;
		l+=1;
		while (r < n) {

			sum = sum + nums[l-1] - nums[r];
			maxSum = Math.max(maxSum, sum);
			r++;
			l++;
		}
		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 1};
		int k = 3;
		MaxPointsFromCards solution = new MaxPointsFromCards();
		int result = solution.maxScore(nums, k);
		System.out.println(result);
	}
}
