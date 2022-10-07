package arvind;

public class LongestPalindromicSubsequence {

    public int findLength(String s1) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = new StringBuilder(s1).reverse().toString().toCharArray();

        int[][] dp = new int[ch2.length + 1][ch1.length + 1];

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (ch1[j-1] == ch2[i-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();
        String s1 = "abdeda";
        int result = solution.findLength(s1);
        System.out.println(result);
    }


}
