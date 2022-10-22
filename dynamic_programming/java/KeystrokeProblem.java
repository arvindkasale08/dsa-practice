public class KeystrokeProblem {
    static long findMaxAs(int n) {
        if (n < 7) {
            return n;
        }

        long[] dp = new long[n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= n; i++) {

            for (int j = 1; j <= 3; j++) {
                dp[i] = Math.max(dp[i], (j + 1) * dp[i - j - 2]);
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int N;
        long res = findMaxAs(7);
        System.out.println(res);

    }
}
