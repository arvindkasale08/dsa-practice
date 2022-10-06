package arvind;

import java.util.Arrays;

public class LongestCommonSubsequenceNoMatrix {

	public int findLCS(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();

		int[] prev = new int[ch1.length + 1];

		for (int i=1; i<ch2.length + 1; i++) {
			int[] curr = new int[ch1.length + 1];
			for (int j=1; j<ch1.length + 1; j++) {
				if (ch1[j-1] == ch2[i-1]) {
					curr[j] = 1 + prev[j-1];
				} else {
					curr[j] = Math.max(prev[j], curr[j-1]);
				}
			}
			prev = Arrays.copyOf(curr, curr.length);
		}

		return prev[prev.length - 1];
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceNoMatrix solution = new LongestCommonSubsequenceNoMatrix();
		String s1 = "abcde";
		String s2 = "acd";

		int result = solution.findLCS(s1, s2);
		System.out.println(result);
	}
}
