public class ValidPalindrome {

    public boolean isValid(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c :s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        String val = builder.toString().toLowerCase();
        String reverse = new StringBuilder(val).reverse().toString();
        return val.equals(reverse);
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean isValid = solution.isValid(s);
        System.out.println(s + " string is a valid palindrome? "+ isValid);
    }
}
