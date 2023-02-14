package leetcode;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String res = "";
        int resLength = 0;

        for (int i=0; i<s.length(); i++) {

            // odd length with i as the middle
            int l =i, r=i;

            while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLength) {
                    res = s.substring(l, r+1);
                    resLength = res.length();
                }
                l -= 1;
                r += 1;
            }

            // even length with i as left and i+1 as right;
            l = i;
            r=i+1;

            while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLength) {
                    res = s.substring(l, r+1);
                    resLength = res.length();
                }
                l -= 1;
                r += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String res = solution.longestPalindrome(s);
        System.out.println(res);
    }
}
