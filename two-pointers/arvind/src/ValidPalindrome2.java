public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return validPalindromeUtil(s, i, j-1) || validPalindromeUtil(s, i+1, j);
            } else {
                i+= 1;
                j-= 1;
            }
        }
        return true;
    }

    private boolean validPalindromeUtil(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i += 1;
                j -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        ValidPalindrome2 solution = new ValidPalindrome2();
        boolean result = solution.validPalindrome(s);
        System.out.println(result);
    }
}
