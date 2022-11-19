package arvind.neetcode;

public class SplitStringInDescending {

	public boolean isValid(String str) {
		char[] ch = str.toCharArray();
		if (isValid(0, null, ch)) return true;
		return false;
	}

	private boolean isValid(int from, Integer prev, char[] ch) {
		if (from == ch.length)
			return true;
		StringBuilder sb = new StringBuilder();
		for (int to=from; to < ch.length; to++) {
			sb.append(ch[to]);
			Integer now = null;
			try {
				now = Integer.parseInt(sb.toString());
			} catch (NumberFormatException ex) {
				return false;
			}
			if (prev != null && now > prev) {
				return false;
			}
			if (prev != null && prev - 1 != now && to == ch.length - 1)
				return false;
			if (now.toString().length() > ch.length / 2)
				return false;
			if (prev == null || now != prev - 1) {
				if (isValid(to+1, now, ch)) return true;
			} else {
				if (isValid(to+1, prev, ch)) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SplitStringInDescending solution = new SplitStringInDescending();
		String str = "0896942443130";
		boolean result = solution.isValid(str);
		System.out.println(result);
	}
}
