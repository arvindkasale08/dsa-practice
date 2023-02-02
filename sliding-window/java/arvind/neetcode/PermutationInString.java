package arvind.neetcode;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		int[] s1bank = new int[26];
		// put s1 in bank
		for (int i=0; i<s1.length(); i++) {
			int idx = s1.charAt(i) - 'a';
			s1bank[idx] += 1;
		}
		int[] s2bank = new int[26];
		// put current window of s2 in bank
		for (int i=0; i<s1.length(); i++) {
			int idx = s2.charAt(i) - 'a';
			s2bank[idx] += 1;
		}
		// find the initial matches value
		int matches = findMatchesInitial(s1bank, s2bank);
		int i=0;
		int j = i+s1.length();
		// get a sliding window of size s1.length and keep on checking the value of matches
		while (j < s2.length()) {
			int iidx = s2.charAt(i) - 'a';
			int jidx = s2.charAt(j) - 'a';

			s2bank[iidx] -=1;
			s2bank[jidx] += 1;
			matches = findMatchesInitial(s1bank, s2bank);

			if (matches == 26) {
				return true;
			}
			i++;
			j++;
		}
		return false;
	}

	private int findMatchesInitial(int[] s1bank, int[] s2bank) {
		int matches = 0;
		for (int i=0; i<26; i++) {
			if (s1bank[i] == s2bank[i]) {
				matches +=1;
			}
		}
		return matches;
	}

	public static void main(String[] args) {
		PermutationInString solution = new PermutationInString();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean result = solution.checkInclusion(s1, s2);
		System.out.println(result);
	}
}
