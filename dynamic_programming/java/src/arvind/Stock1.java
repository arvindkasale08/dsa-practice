package arvind;

/**
 * https://takeuforward.org/data-structure/stock-buy-and-sell-dp-35/
 */
public class Stock1 {

	public int maxProfit(int[] arr) {
		int min = arr[0];
		int maxProfit = 0;

		for (int i=1; i<arr.length; i++) {
			maxProfit = Math.max(maxProfit, arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		Stock1 solution = new Stock1();
		int[] arr = {7, 1, 5, 3, 6, 4};
		int profit = solution.maxProfit(arr);
		System.out.println(profit);
	}
}
