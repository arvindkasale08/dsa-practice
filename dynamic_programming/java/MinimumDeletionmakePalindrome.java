public class MinimumDeletionmakePalindrome {
    static int lps(String s1){
        int n = s1.length();
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < n;i++){
            dp[i][i] = 1;
        }
        int i = 0;
        int j = 1;
        int J = 2;
        while (i != 0 || j != n){
            if(s1.charAt(i) == s1.charAt(j)){
                dp[i][j] = 2 + dp[i + 1][j - 1];
            }
            else{
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
            i += 1;
            j += 1;
            if (j == n){
                i = 0;
                j = J;
                J = J + 1;
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        String str1 = "ADCECA";
        System.out.println(str1.length() - lps(str1));
    }
}
