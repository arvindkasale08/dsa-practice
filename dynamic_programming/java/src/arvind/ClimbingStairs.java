package arvind;

import java.util.Arrays;

/**
 * Its actually fibonaci
 */
public class ClimbingStairs {
    public int findWays(int index) {
        int[] dp = new int[index + 1];
        Arrays.fill(dp, -1);
        return findWays(index, dp);
    }

    private int findWays(int index, int[] dp) {
        if (index == 0) return 1;
        if (index == 1) return 1;
        if (dp[index] != -1) return dp[index];
        int left = findWays(index - 1, dp);
        int right = findWays(index - 2, dp);
        dp[index] = left + right;
        return dp[index];
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 3;
        int noOfWays = solution.findWays(n);
        System.out.println(noOfWays);
    }
}
