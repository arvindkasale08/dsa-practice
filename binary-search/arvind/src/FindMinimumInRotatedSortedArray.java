public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		int n = nums.length;
		int low = 0;
		int high = n -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			min = Math.min(nums[mid], min);
			if (nums[mid] < nums[high]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return min;
	}


	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray solution = new FindMinimumInRotatedSortedArray();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int min = solution.findMin(nums);
		System.out.println(min);
	}
}
