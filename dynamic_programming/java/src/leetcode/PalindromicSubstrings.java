package leetcode;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count = 0;

        for (int i=0; i<s.length(); i++) {

            // for odd length palindromes
            int l = i,  r=i;

            while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count += 1;
                l -= 1;
                r += 1;
            }

            l = i;
            r = i+1;
            while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                count += 1;
                l -= 1;
                r += 1;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings solutions = new PalindromicSubstrings();
        int res = solutions.countSubstrings(s);
        System.out.println(res);
    }
}
