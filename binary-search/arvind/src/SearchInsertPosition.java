public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		return searchInsert(nums, target, 0, nums.length - 1);
	}

	private int searchInsert(int[] nums, int target, int low, int high) {
		if (low > high) {
			return low;
		}
		int middle = (low + high) / 2;

		if (target == nums[middle]) {
			return middle;
		}
		if (target < nums[middle]) {
			return searchInsert(nums, target, low, middle - 1);
		} else {
			return searchInsert(nums, target, middle + 1, high);
		}
	}

	public static void main(String[] args) {
		SearchInsertPosition solution = new SearchInsertPosition();
		int[] nums = new int[] {1, 3, 5, 6};
		int target = 2;
		int idx = solution.searchInsert(nums, target);
		System.out.println(idx);
	}

}
