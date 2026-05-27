package com.arvind.revision;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {

    private Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public String reverseVowels(String s) {
        // TODO: Write your code here
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (left < right) {
            if (isVowel(c[left]) && isVowel(c[right])) {
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            if (!isVowel(c[left])) {
                left++;
            }
            if (!isVowel(c[right])) {
                right--;
            }
        }
        return new String(c);
    }

    private boolean isVowel(char c) {
        return vowel.contains(Character.toLowerCase(c));
    }

    public static void main(String[] args) {
        String s1= "hello";
        String s2= "DesignGUrus";
        ReverseVowels v = new ReverseVowels();
        System.out.println(v.reverseVowels(s1));
        System.out.println(v.reverseVowels(s2));
    }
}
