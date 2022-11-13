package arvind.striver;

public class CheckIfStringIsPalindrome {

    public boolean isPalindrome(String s) {
        return isPalindrome(s, 0);
    }

    private boolean isPalindrome(String s, int idx) {
        if (idx >= s.length() / 2)
            return true;
        boolean check = s.charAt(idx) == s.charAt(s.length()-idx-1);
        return check && isPalindrome(s, idx + 1);
    }

    public static void main(String[] args) {
        CheckIfStringIsPalindrome solution = new CheckIfStringIsPalindrome();
        String str = "5?36@6?35";
        boolean result = solution.isPalindrome(str);
        System.out.println(result);
    }
}
