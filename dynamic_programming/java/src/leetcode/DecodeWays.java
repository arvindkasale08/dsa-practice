package leetcode;

import java.util.Arrays;

public class DecodeWays {

    public int numDecodingDP(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        if (s.charAt(0) == '0') {
            return 0;
        }
        // empty string
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        Arrays.fill(dp, 1);

        for (int i=2; i<=n; i++) {
            int sum = dp[i - 1];
            int now = Character.getNumericValue(s.charAt(i-1));
            if (now == 0) {
                dp[i] = 0;
            }
            int next = i + 1 <= n ? Character.getNumericValue(s.charAt(i-2)) : 9999;
            if (now < 3) {
                if (next != 9999) {
                    if ((now == 2 && next < 7) || (now < 2)) {
                        sum += dp[i - 2];
                    }
                }
            }
            dp[i] += sum;
        }
        return dp[n];
    }

    public int numDecodingsMemo(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        if (s.charAt(0) == '0') {
            return 0;
        }
        return numDecodingsMemo(0, n, s, memo);
    }

    private int numDecodingsMemo(int idx, int n, String s, int[] memo) {
        if (idx >= n) {
            return 1;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        int sum = numDecodingsMemo(idx+1, n, s, memo);
        int now = Character.getNumericValue(s.charAt(idx));
        if (now == 0) {
            return 0;
        }
        int next = idx + 1 < n ? Character.getNumericValue(s.charAt(idx+1)) : 9999;
        if (now < 3) {
            if (next != 9999) {
                if ((now == 2 && next < 7) || (now < 2)) {
                    sum += numDecodingsMemo(idx+2, n, s, memo);
                }
            }
        }
        return memo[idx] = Math.max(memo[idx], sum);
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        String s = "226";
        int res = solution.numDecodingDP(s);
        System.out.println(res);
    }
}
