package arvind.neetcode;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		int[] bank = new int[26];
		// put s1 in bank
		for (int i=0; i<s1.length(); i++) {
			int idx = s1.charAt(i) - 'a';
			bank[idx] += 1;
		}
		// get a sliding window and check

		for (int r=0; r<)
	}

	public static void main(String[] args) {
		PermutationInString solution = new PermutationInString();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean result = solution.checkInclusion(s1, s2);
		System.out.println(result);
	}
}
