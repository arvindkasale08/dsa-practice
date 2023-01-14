package arvind.neetcode;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> bank = new HashMap<>();
        if (s.length() != t.length()) {
            // cant be isomorphic
            return false;
        }
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            }
            if (bank.containsKey(s.charAt(i)) && bank.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            bank.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egd";
        String t = "add";
        IsomorphicStrings solution = new IsomorphicStrings();
        boolean result = solution.isIsomorphic(s, t);
        System.out.println(result);
    }
}
