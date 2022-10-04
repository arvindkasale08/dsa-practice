public class CoinChange {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 4};
        int t = 7;
        int res = change(t, a);
        System.out.println(res);
    }
}
