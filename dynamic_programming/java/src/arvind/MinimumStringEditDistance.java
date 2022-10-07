package arvind;

public class MinimumStringEditDistance {

    public int findMinimumDistance(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        if (ch1.length == 0)
            return ch2.length;
        if (ch2.length == 0)
            return ch1.length;

        int[][] dp = new int[ch2.length + 1][ch1.length + 1];

        for (int i=0; i<dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i=0; i<dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (ch1[j-1] == ch2[i-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumStringEditDistance solution = new MinimumStringEditDistance();
        String s1 = "a";
        String s2 = "b";

        int dist = solution.findMinimumDistance(s1, s2);
        System.out.println(dist);
    }
}
