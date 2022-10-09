package arvind;

public class UnboundedKnapsack {

    public int steal(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (j < weights[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = values[i-1] + dp[i][j-weights[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[] weights = {1, 50};
        int[] values = {1, 30};
        int capacity = 100;

        UnboundedKnapsack solution = new UnboundedKnapsack();
        int stolenValue = solution.steal(weights, values, capacity);
        System.out.println(stolenValue);
    }
}
