package arvind.neetcode;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] freq = new int[26];

        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
            freq[t.charAt(i) - 'a'] -= 1;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        ValidAnagram solution = new ValidAnagram();
        boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }
}
