package arvind.neetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueBinaryString {

	public String findUniqueString(String[] arr) {
		int n = arr.length;
		Set<String> set = new HashSet<>();
		for (String s : arr) {
			set.add(s);
		}
		String[] ans = new String[1];
		findUniqueString(0, n, "", ans, set);
		return ans[0];
	}

	private boolean findUniqueString(int i, int n, String s, String[] ans, Set<String> set) {
		if (i == n && !set.contains(s)) {
			ans[0] = s;
			return true;
		}
		if (i == n)
			return false;
		if (findUniqueString(i+1, n, s.concat("0"), ans, set)) return true;
		if (findUniqueString(i+1, n, s.concat("1"), ans, set)) return true;
		return false;
	}

	public static void main(String[] args) {
		String[] arr = {"01", "10"};
		UniqueBinaryString solution = new UniqueBinaryString();
		String str = solution.findUniqueString(arr);
		System.out.println(str);
	}
}
