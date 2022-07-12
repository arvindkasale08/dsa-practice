package practice2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int find(String input) {
        char[] arr = input.toCharArray();
        int n = arr.length;
        int i = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        for (int j=0; j<n; j++) {
            while(charSet.contains(arr[j])) {
                charSet.remove(arr[i]);
                i++;
            }
            charSet.add(arr[j]);
            maxLength = Math.max(maxLength, j-i+1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String input = "abcdeabeann";
        int length = solution.find(input);
        System.out.println("Max substring with non repeating chars is "+ length);
    }
}
