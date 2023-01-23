import java.util.Arrays;

public class SquaresOfSortedArray {

	public int[] sortedSquares(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		int i = nums.length - 1;
		int[] result = new int[nums.length];

		while (l <= r) {
			if (Math.abs(nums[l]) > Math.abs(nums[r])) {
				result[i] = nums[l] * nums[l];
				l += 1;
			} else {
				result[i] = nums[r] * nums[r];
				r -= 1;
			}

			i--;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {-4, -1, 0, 3, 10};
		SquaresOfSortedArray solution = new SquaresOfSortedArray();
		int[] result = solution.sortedSquares(nums);
		System.out.println(Arrays.toString(result));
	}
}
