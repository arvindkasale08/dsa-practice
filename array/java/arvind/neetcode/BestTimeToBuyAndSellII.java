package arvind.neetcode;

public class BestTimeToBuyAndSellII {

    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int buy = prices[0];

        for (int i=1; i<prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                totalProfit += prices[i-1] - buy;
                buy = prices[i];
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellII solution = new BestTimeToBuyAndSellII();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
