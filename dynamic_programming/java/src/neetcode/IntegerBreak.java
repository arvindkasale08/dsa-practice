package neetcode;

import java.util.Arrays;

public class IntegerBreak {

    public int integerBreakDP(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i=2; i<= n; i++) {
            int res = i == n ? 0 : i;
            for (int k=1; k<i; k++) {
                int val = dp[k] * dp[i-k];
                res = Math.max(val, res);
            }
            dp[i] = res;
        }
        return dp[n];
    }

    public int integerBreakMemo(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, - 1);
        return dfs(n, n, memo);
    }

    private int dfs(int n, int ip, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        int res = n == ip ? 0 : n;
        for (int i=1; i<n; i++) {
            int val = dfs(i, ip, memo) * dfs(n-i, ip, memo);
            res = Math.max(val, res);
        }
        return memo[n] = res;
    }

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        int n = 20;
        int res = solution.integerBreakMemo(n);
        int res2 = solution.integerBreakDP(n);
        System.out.println(res);
        System.out.println(res2);
    }
}
