package arvind;

/**
 * https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/
 */
public class MCM {

	public int findLowestCost(int[] arr) {
		return findLowestCost(arr, 1, arr.length -1);
	}

	private int findLowestCost(int[] arr, int i, int j) {
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;
		for (int k=i; k<j; k++) {
			int left = findLowestCost(arr, i, k);
			int right = findLowestCost(arr, k+1, j);
			int cost = arr[i-1] * arr[k] * arr[j];
			min = Math.min(min, left + right + cost);
		}
		return min;
	}

	public static void main(String[] args) {
		MCM solution = new MCM();
		int[] arr = {10, 20, 30, 40, 50};
		int cost = solution.findLowestCost(arr);
		System.out.println(cost);
	}
}
