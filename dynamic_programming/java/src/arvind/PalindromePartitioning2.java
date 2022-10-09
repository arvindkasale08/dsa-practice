package arvind;

/**
 * Leetcode link - https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning2 {

    public int findCuts(String s1) {
        char[] ch = s1.toCharArray();
        int[][] dp = new int[ch.length][ch.length];
        Boolean[][] pali = new Boolean[ch.length][ch.length];
        //preinit dp
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j< dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return findCuts(ch, 0, ch.length - 1, dp, pali);
    }

    private boolean isPal(char[] ch, int i, int j, Boolean[][] pali) {
        if (pali[i][j] != null) return pali[i][j];
        int k =i, l = j;
        while (k < l) {
            if (ch[k] != ch[l]) {
                pali[i][j] = false;
                return false;
            }
            k++;
            l--;
        }
        pali[i][j] = true;
        return true;
    }

    private int findCuts(char[] ch, int i, int j, int[][] dp, Boolean[][] pali) {
        if (i == j) return 0; // if i moves beyond j no cut needed
        if (isPal(ch, i, j, pali)) return 0; // no cut needed for palindrome
        if (dp[i][j] != -1) return dp[i][j];
        int result = Integer.MAX_VALUE;
        for (int k = i; k<j; k++) {
            int left = findCuts(ch, i, k, dp, pali);
            int right = findCuts(ch, k+1, j, dp, pali);
            int cost = 1;
            result = Integer.min(result, (left + right + cost));
        }
        dp[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        PalindromePartitioning2 solution = new PalindromePartitioning2();
        String s1 = "abcbd";
        // tle input
        s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    // expected output is 3 cuts ["a", "bcb", "d"]
        int cuts = solution.findCuts(s1);
        System.out.println(cuts);
    }
}
