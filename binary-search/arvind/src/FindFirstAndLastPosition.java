import java.util.Arrays;

public class FindFirstAndLastPosition {

	public int[] searchRange(int[] nums, int target) {
		// do e binary searches one leaning left and one leaning right
		boolean isLeft = true;
		int l = binarySearch(nums, target, isLeft);
		isLeft = false;
		int r = binarySearch(nums, target, isLeft);

		return new int[] {l, r};
	}

	private int binarySearch(int[] nums, int target, boolean isLeft) {
		int low = 0;
		int high = nums.length - 1;
		boolean found = false;

		while (low <= high) {
			int middle = low + (high - low) / 2;

			if (nums[middle] == target) {
				found = true;
				if (isLeft) {
					high = middle - 1;
					continue;
				} else {
					low = middle + 1;
					continue;
				}
			}

			if (nums[middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		if (!found) {
			return -1;
		}
		return isLeft ? low : high;
	}

	public static void main(String[] args) {
		FindFirstAndLastPosition solution = new FindFirstAndLastPosition();
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] res = solution.searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}
}
