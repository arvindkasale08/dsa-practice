package arvind.neetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength3sizePalindromes {

    public int countPalindromicSubsequence(String s) {
        Set<String> result = new HashSet<>();
        Set<Character> left = new HashSet<>();
        HashMap<Character, Integer> right = new HashMap<>();

        for (char ch : s.toCharArray()) {
            right.put(ch, right.getOrDefault(ch, 0)+1);
        }

        for (int i=0; i<s.length(); i++) {
            char mid = s.charAt(i);
            // remove mid occurence from right as its no longer available
            int midcount = right.get(mid);
            if (midcount == 1) {
                right.remove(mid);
            } else {
                right.put(mid, midcount-1);
            }

            for (int j=0; j<26; j++) {
                char ch = (char) (97 + j);
                // check if char ch is on left
                boolean isleft = left.contains(ch);
                boolean isRight = right.containsKey(ch);
                if (isleft && isRight) {
                    result.add("" + ch + mid + ch);
                }
            }


            left.add(mid);
        }

        return result.size();
    }

    public static void main(String[] args) {
        UniqueLength3sizePalindromes solution = new UniqueLength3sizePalindromes();
        String s = "bbcbaba";
        int count = solution.countPalindromicSubsequence(s);
        System.out.println(count);
    }
}
