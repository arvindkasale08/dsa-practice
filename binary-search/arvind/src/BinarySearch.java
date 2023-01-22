public class BinarySearch {

	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int middle = (low + high) / 2;

			if (nums[middle] == target) {
				return middle;
			}

			if (nums[middle] < target) {
				low = middle + 1;
			} else {
				high = middle - 1;

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 9;
		BinarySearch solution = new BinarySearch();
		int idx = solution.search(nums, target);
		System.out.println(idx);
	}
}
