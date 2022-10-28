package arvind;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {

	private boolean checkPossible(String curr, String previous) {
		if (curr.length() != previous.length() + 1) return false;
		int first = 0;
		int second = 0;
		while (first < curr.length()) {
			if (second < previous.length() && curr.charAt(first) == previous.charAt(second)) {
				first++;
				second++;
			} else {
				first++;
			}
		}

		if (first == curr.length() && second == previous.length()) return true;
		return false;
	}

	public int findLongestStringChainLength(String[] str) {
		// sort the array by length second order sorting is automatically managed

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		int n = str.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1); // har point pe length is 1, preinit dp array

		int maxi = 1;
		for (int i=1; i< n; i++) {
			for (int j=0; j<i; j++) {
				if (checkPossible(str[i], str[j])) {
					if (1+dp[j] > dp[i]) {
						dp[i] = 1 + dp[j];
						maxi = Math.max(dp[i], maxi);
					}
				}
			}
		}




		return maxi;
	}

	public static void main(String[] args) {
		LongestStringChain solution = new LongestStringChain();
		String[] str = {"xbc","pcxbcf","xb", "db","cxbc","pcxbc"};
		int result = solution.findLongestStringChainLength(str);
		System.out.println(result);
	}
}
