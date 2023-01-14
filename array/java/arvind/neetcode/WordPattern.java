package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();

        for (int i=0; i<words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!charToString.containsKey(c)) {
                charToString.put(c, word);
            }

            if (!stringToChar.containsKey(word)) {
                stringToChar.put(word, c);
            }

            if (!charToString.get(c).equals(word) || stringToChar.get(word) != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat fox dog";
        WordPattern solution = new WordPattern();
        boolean result = solution.wordPattern(pattern, s);
        System.out.println(result);
    }
}
