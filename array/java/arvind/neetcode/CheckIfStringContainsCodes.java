package arvind.neetcode;

import java.util.HashSet;

public class CheckIfStringContainsCodes {

	public boolean hasAllCodes(String s, int k) {
		HashSet<String> set = new HashSet<>();

		for (int i=0; i<s.length()-k; i++) {
			String window = s.substring(i, i+k);
			set.add(window);
		}
		return set.size() == (int) Math.pow(2, k);
	}

	public static void main(String[] args) {
		String s = "0110";
		int k = 2;
		CheckIfStringContainsCodes solution = new CheckIfStringContainsCodes();
		boolean result = solution.hasAllCodes(s, k);
		System.out.println(result);
	}
}
