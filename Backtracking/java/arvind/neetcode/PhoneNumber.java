package arvind.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

	public List<String> find(String digits) {
		char[] ch = digits.toCharArray();
		Map<Character, String> map = new HashMap<>() {
			{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");
			}
		};
		List<String> result = new ArrayList<>();
		find(0, new StringBuilder(), ch, map, result);
		return result;
	}

	private void find(int idx, StringBuilder res, char[] ch, Map<Character, String> map, List<String> result) {
		if (idx == ch.length) {
			result.add(res.toString());
			return;
		}

		for (char c : map.get(ch[idx]).toCharArray()) {
			res.append(c);
			find(idx+1, res, ch, map, result);
			res.setLength(res.length() - 1);
		}
	}

	public static void main(String[] args) {
		PhoneNumber solution = new PhoneNumber();
		String digits = "23";
		List<String> result = solution.find(digits);
		System.out.println(result);
	}
}
