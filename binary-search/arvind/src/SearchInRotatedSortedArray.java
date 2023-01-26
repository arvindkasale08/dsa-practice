public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		int n = nums.length;
		int low = 0;
		int high = n -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				return mid;
			}
			// check if left is sorted
			if (nums[mid] >= nums[low] ) {
				if (nums[low] <= target && nums[mid] >= target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (nums[mid] <= target && nums[high] >= target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
		int target = 0;
		SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
		int idx = solution.search(nums, target);
		System.out.println(idx);
	}
}
