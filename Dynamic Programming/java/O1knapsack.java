public class O1knapsack {
    static int knapSack(int W, int wt[], int val[], int n) {
        int []dp = new int[W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {

                if (wt[i - 1] <= w)

                    dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
            }
        }
        return dp[W];
    }
    public static void main(String[] args)
    {
        int val[] = { 1, 2, 3 };
        int wt[] = { 4, 5, 1 };
        int W = 4;
        int n = val.length;
        System.out.print(knapSack(W, wt, val, n));
    }
}
