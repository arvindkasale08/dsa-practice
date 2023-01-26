import java.util.Arrays;

public class SplitArrayLargestSum {

	public int splitArray(int[] nums, int k) {
		int left = Arrays.stream(nums).max().getAsInt();
		int right = Arrays.stream(nums).sum();
		int res = right;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (canSplit(nums, middle, k)) {
				res = Math.min(res, middle);
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return res;
	}

	private boolean canSplit(int[] nums, int middle, int k) {
		int subarray = 0;
		int currSum = 0;
		for (int num : nums) {
			currSum += num;
			if (currSum > middle) {
				subarray += 1;
				currSum = num;
			}
		}
		return subarray + 1 <= k;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {7, 2, 5, 10, 8};
		int k = 2;
		SplitArrayLargestSum solution = new SplitArrayLargestSum();
		int sum = solution.splitArray(nums, k);
		System.out.println(sum);
	}

}
