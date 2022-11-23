package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {

	public boolean isSorted(String[] words, String order) {
		Map<Character, Integer> orderIDX = new HashMap<>();
		char[] ch = order.toCharArray();
		for (int i=0; i< ch.length; i++) {
			orderIDX.put(ch[i], i);
		}
		if (words.length == 1) {
			return true;
		}
		int i = 0;
		int j = 1;
		while(j < words.length) {
			if (!isSorted(words[i], words[j], orderIDX)) return false;
			i++;
			j++;
		}
		return true;
	}

	private boolean isSorted(String u, String v, Map<Character, Integer> orderIDX) {
		int i = 0;
		int j = 0;
		while (i < u.length() && j < v.length()) {
			char uc = u.charAt(i);
			char vc = v.charAt(j);
			if (uc != vc) {
				if (orderIDX.get(uc) > orderIDX.get(vc)) {
					return false;
				} else {
					return true;
				}
			}
			i++;
			j++;
		}
		if (i == u.length())
			return true;
		if (j == v.length())
			return false;
		return true;
	}

	public static void main(String[] args) {
		VerifyingAlienDictionary solution = new VerifyingAlienDictionary();
		String[] words = {"hell", "hello"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		boolean flag = solution.isSorted(words, order);
		System.out.println(flag);
	}
}
