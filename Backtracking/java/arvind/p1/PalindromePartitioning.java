package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public List<List<String>> find(String str) {
		List<List<String>> result = new ArrayList<>();
		find(0, new ArrayList<>(), str, result);
		return result;
	}

	private void find(int start, List<String> list, String str, List<List<String>> result) {
		if (start == str.length()) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int k = start; k < str.length(); k++) {
			String newString = str.substring(start, k+1);
			if (isPalindrome(newString)) {
				list.add(newString);
				find(k + 1, list, str, result);
				list.remove(list.size() - 1);
			}
		}

	}

	private boolean isPalindrome(String str) {
		int i = 0;
		int k = str.length() -1;
		while (i < k) {
			if (str.charAt(i) != str.charAt(k)) return false;
			i++;
			k--;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "aab";
		PalindromePartitioning solution = new PalindromePartitioning();
		List<List<String>> result = solution.find(str);
		System.out.println(result);
	}
}
