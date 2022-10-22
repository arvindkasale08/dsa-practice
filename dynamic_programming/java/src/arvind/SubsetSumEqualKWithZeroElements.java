package arvind;

public class SubsetSumEqualKWithZeroElements {

	public int countWays(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target + 1];
		return countWays(arr, target, n-1, dp);
	}

	private int countWays(int[] arr, int target, int index, int[][] dp) {
		if (index == 0) {
			if (target == 0 && arr[index] == 0)
				return 2;
			if (target == 0 || target == arr[0]) {
				return 1;
			}
			return 0;
		}

		int dontpick = countWays(arr, target, index-1, dp);
		int pick = 0;
		if (arr[index] <= target) {
			pick = countWays(arr, target - arr[index], index-1, dp);
		}
		return pick + dontpick;
	}

	public static void main(String[] args) {
		SubsetSumEqualKWithZeroElements solution = new SubsetSumEqualKWithZeroElements();
		int[] arr = {0, 0, 1};
		int target = 1;
		int ways = solution.countWays(arr, target);
		System.out.println(ways);
	}
}
