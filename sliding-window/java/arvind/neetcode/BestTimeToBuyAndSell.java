package arvind.neetcode;

public class BestTimeToBuyAndSell {

	public int maxProfit(int[] prices) {
		int profit = 0;
		int min = prices[0];

		for (int i=1; i<prices.length; i++) {
			profit = Math.max(prices[i] - min, profit);
			min = Math.min(min, prices[i]);
		}

		return profit;
	}

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		BestTimeToBuyAndSell solution = new BestTimeToBuyAndSell();
		int profit = solution.maxProfit(prices);
		System.out.println(profit);
	}
}
