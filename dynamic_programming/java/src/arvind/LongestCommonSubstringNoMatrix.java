package arvind;

import java.util.Arrays;

public class LongestCommonSubstringNoMatrix {

	public int findLCS(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int[] prev = new int[ch1.length + 1];
		int count = 0;
		for (int i=1; i< ch2.length + 1; i++) {
			int[] curr = new int[ch1.length + 1];
			for (int j=1; j<ch1.length +1; j++) {
				if (ch1[j-1] == ch2[i-1]) {
					curr[j] = prev[j-1] + 1;
					count = Math.max(count, curr[j]);
				}
			}
			prev = Arrays.copyOf(curr, curr.length);
		}

		return count;
	}

	public static void main(String[] args) {
		LongestCommonSubstringNoMatrix solution = new LongestCommonSubstringNoMatrix();
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		int result = solution.findLCS(s1, s2);
		System.out.println(result);
	}
}
