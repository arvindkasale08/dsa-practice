package arvind.neetcode;

public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int[] bank = new int[26];
		int l = 0;
		int span = 0;
		for (int r=0; r<s.length(); r++) {
			int idx2 = s.charAt(r) - 'A';
			bank[idx2] += 1;
			while (!isValid(l, r, s, k, bank)) {
				int idx = s.charAt(l) - 'A';
				bank[idx] -= 1;
				l++;
			}
			span = Math.max(span, r-l+1);
		}

		return span;
	}

	private boolean isValid(int l, int r, String s, int k, int[] bank) {
		int maxCount = 0;
		for (int i=0; i<26; i++) {
			maxCount = Math.max(maxCount, bank[i]);
		}
		return (maxCount + k) >= (r-l+1);
	}


	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
		String s = "AABABBA";
		int k = 1;
		int op = solution.characterReplacement(s, k);
		System.out.println(op);
	}
}
