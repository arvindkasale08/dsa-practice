package com.arvind.revision.warmup;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // TODO: Write your code here
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (left < right) {
            char lChar = Character.toLowerCase(c[left]);
            char rChar = Character.toLowerCase(c[right]);
            if (!(Character.isAlphabetic(lChar) || Character.isDigit(lChar))) {
                left++;
                continue;
            }
            if (!(Character.isAlphabetic(rChar) || Character.isDigit(rChar))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(c[left]) != Character.toLowerCase(c[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal, Panama!";
        String s2 = "Was it a car or a cat I saw?";
        String s3 = "123321";

        ValidPalindrome palindrome = new ValidPalindrome();
        System.out.println(palindrome.isPalindrome(s1));
        System.out.println(palindrome.isPalindrome(s2));
        System.out.println(palindrome.isPalindrome(s3));
    }
}
