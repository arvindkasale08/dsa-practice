package arvind;

public class O1Knapsack {

    public int find(int[] weights, int[] values, int capacity) {
        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i=1; i< dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (j < weights[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = values[i-1] + dp[i-1][j-weights[i-1]];
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        O1Knapsack solution = new O1Knapsack();
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        int capacity = 5;

        int stolenvalue = solution.find(weights, values, capacity);
        System.out.println(stolenvalue);
    }
}
