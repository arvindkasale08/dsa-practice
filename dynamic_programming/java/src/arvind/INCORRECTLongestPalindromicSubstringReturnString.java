package arvind;

public class INCORRECTLongestPalindromicSubstringReturnString {

    // returns an int how to convert to return a string
    public String findLPSubstring(String s1) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = new StringBuilder(s1).reverse().toString().toCharArray();
        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        int k = 0;
        int maxLength = 0;
        for (int i=1; i< dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (ch1[j-1] == ch2[i-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if (maxLength < dp[i][j]) {
                        maxLength = dp[i][j];
                        k = j;
                    }
                }
            }
        }
        char[] result = new char[maxLength];
        System.out.println(maxLength);

        while (maxLength > 0) {
            result[maxLength - 1] = ch1[k-1];
            k = k-1;
            maxLength -= 1;
        }

        return new String(result);
    }

    public static void main(String[] args) {
        INCORRECTLongestPalindromicSubstringReturnString solution = new INCORRECTLongestPalindromicSubstringReturnString();
        String s1 = "aacabdkacaa";
        String result = solution.findLPSubstring(s1);
        System.out.println(result);
    }
}
