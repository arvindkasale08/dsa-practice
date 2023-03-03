package neetcode;

import java.util.Arrays;

public class BestTimeToBuySellStockCoolDown {

    public int maxProfitMemo(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return maxProfitMemo(0, n, 1, prices, memo);
    }

    private int maxProfitMemo(int idx, int n, int canBuy, int[] prices, int[][] memo) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx][canBuy] != -1) {
            return memo[idx][canBuy];
        }

        if (canBuy == 1) {
            // I can buy on the day
            int buy = - prices[idx] + maxProfitMemo(idx+1, n, 0, prices, memo);
            int doNothing = 0 + maxProfitMemo(idx+1, n,  1, prices, memo);
            return memo[idx][canBuy] = Math.max(buy, doNothing);
        } else {
            // I cant buy on the day
            int sell = prices[idx] + maxProfitMemo(idx+2, n, 1, prices, memo);
            int doNothing = 0 + maxProfitMemo(idx+1, n, 0, prices, memo);
            return memo[idx][canBuy] = Math.max(sell, doNothing);
        }
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1, 2, 3, 0, 2};
        BestTimeToBuySellStockCoolDown solution = new BestTimeToBuySellStockCoolDown();
        int res = solution.maxProfitMemo(prices);
        System.out.println(res);
    }
}
