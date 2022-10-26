package arvind;

/**
 * https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/
 */
public class Stock2NonDP {

	public int findMaxProfit(int[] arr) {
		int totalProfit = 0;
		int buy = arr[0];

		for (int i=1; i<arr.length; i++) {
			if (arr[i] < arr[i-1]) {
				totalProfit += arr[i-1] - buy;
				buy = arr[i];
			}
		}
		return totalProfit + arr[arr.length-1] - buy;
	}

	public static void main(String[] args) {
		Stock2NonDP solution = new Stock2NonDP();
		int[] arr = {7, 1, 5, 3, 6, 4};
		int result = solution.findMaxProfit(arr);
		System.out.println(result);
	}
}
