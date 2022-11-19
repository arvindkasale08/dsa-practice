package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

	public List<String> permute(String str) {
		List<String> result = new ArrayList<>();
		permute(0, result, str.toCharArray());
		return result;
	}

	private void permute(int i, List<String> result, char[] ch) {
		if (i == ch.length) {
			result.add(new String(ch));
		}

		for (int idx = i; idx<ch.length; idx++) {
			swap(ch, i, idx);
			permute(i+1, result, ch);
			swap(ch, i, idx);
		}
	}

	private void swap(char[] ch, int a, int b) {
		char tmp = ch[a];
		ch[a] = ch[b];
		ch[b] = tmp;
	}

	public static void main(String[] args) {
		PermutationString solution = new PermutationString();
		String str = "ABC";
		List<String> result = solution.permute(str);
		System.out.println(result);
	}
}
