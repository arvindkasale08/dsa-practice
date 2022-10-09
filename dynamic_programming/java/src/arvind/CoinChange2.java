package arvind;

public class CoinChange2 {

    public int findWays(int[] coins, int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];

        // preinitiatize
        for (int i=0; i< dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i=0; i< dp.length; i++) {
            dp[i][0] = 1; // set first row as 0;
        }

        for (int i=1; i<dp.length; i++) {
            for (int j= 1; j<dp[0].length; j++) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[dp.length -1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        CoinChange2 solution = new CoinChange2();
        int sum = 4;
        int[] coins = new int[] {1, 2, 3};
        int ways = solution.findWays(coins, sum);
        System.out.println(ways);
    }
}
