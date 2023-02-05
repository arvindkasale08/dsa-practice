public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        int num = x;
        // Get the initial divisor
        while (num > 9) {
            div = div * 10;
            num = num / 10;
        }

        while (x > 0) {
            if (x / div != x % 10) return false;
            x = (int) ((x % div) / 10);
            div = div / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int x = 1121;
        boolean result = solution.isPalindrome(x);
        System.out.println(result);
    }
}
