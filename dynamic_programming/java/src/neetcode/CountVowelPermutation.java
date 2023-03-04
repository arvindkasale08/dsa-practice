package neetcode;

public class CountVowelPermutation {

    public int countVowelPermutation(int n) {
        int mod = 1_000_000_007;
        // keep zero indexed rep for a=0, e=1, i=2, o=3, u=4
        int[][] references = new int[][] {
                {1, 2, 4}, // a can be obtained from e, i, u
                {0, 2}, // e can be obtained from a and i
                {1, 3}, // i from e and o
                {2}, // o from i
                {2, 3} // u in i and o
        };

        int[][] dp = new int[5][n+1];
        // prefill the first column
        for (int i=0; i<5; i++) {
            dp[i][1] = 1;
        }

        for (int j=2; j<=n; j++) {
            for (int i=0; i<5; i++) {
                int sum = 0;
                for (int idx : references[i]) {
                    sum = (sum + dp[idx][j-1]) % mod;
                }

                dp[i][j] = sum;
            }
        }

        int ans = 0;
        for (int i=0; i<5; i++) {
            ans = (ans + dp[i][n]) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        CountVowelPermutation solution = new CountVowelPermutation();
        int res = solution.countVowelPermutation(n);
        System.out.println(res);
    }
}
