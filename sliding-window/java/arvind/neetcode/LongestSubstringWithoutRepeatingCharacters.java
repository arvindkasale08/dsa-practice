package arvind.neetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		int l = 0;
		int r = 0;
		HashSet<Character> bank = new HashSet<>();
		int count = 0;
		while(r < s.length()) {
			char c = s.charAt(r);
			while (bank.contains(c)) {
				bank.remove(s.charAt(l));
				l++;
			}
			bank.add(c);
			r++;
			count = Math.max(count, (r-l));
		}

		return count;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcbb";
		int result = solution.lengthOfLongestSubstring(s);
		System.out.println(result);
	}
}
