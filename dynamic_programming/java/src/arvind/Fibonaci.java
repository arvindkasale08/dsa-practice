package arvind;

import java.util.Arrays;

public class Fibonaci {

    public int findRecursionTabulationSpaceOptimised(int n) {
        int prev = 1;
        int prev2 = 0;
        for (int i=2; i<=n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int findRecursionTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length - 1];
    }

    public int findRecursionMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findRecursionMemo(n, dp);
    }

    private int findRecursionMemo(int n, int[] dp) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] != -1) return dp[n];
        dp[n] = findRecursionMemo(n-1, dp) + findRecursionMemo(n-2, dp);
        return dp[n];
    }
    public int findRecursion(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return findRecursion(n-1) + findRecursion(n-2);
    }

    public static void main(String[] args) {
        Fibonaci solution = new Fibonaci();
        int n = 5;
        int res1 = solution.findRecursionTabulationSpaceOptimised(n);
        System.out.println(res1);
    }
}
