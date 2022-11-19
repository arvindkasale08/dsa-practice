package arvind.neetcode;

public class SplitStringsInDescendingNotWorking {

	public boolean hasDescending(String s) {
		char[] ch = s.toCharArray();
		int halflength = ch.length / 2;
		return hasDescending(0, 1000000000, ch, halflength);
	}

	private boolean hasDescending(int from, int last, char[] ch, int halflength) {
		if (from == ch.length)
			return true;
		StringBuilder sb = new StringBuilder();
		for (int to=from; to < ch.length; to++) {
			sb.append(ch[to]);
			Integer now = Integer.parseInt(sb.toString());
			if (now != last - 1 && (now > last + 1 || to >= ch.length - 1))
				return false;
			if (hasDescending(to+1, now, ch, halflength)) return true;
			//sb.setLength(sb.length()-1);
		}

		return false;
	}

	public static void main(String[] args) {
		SplitStringsInDescendingNotWorking solution = new SplitStringsInDescendingNotWorking();
		String s = "0896942443130";
		boolean result = solution.hasDescending(s);
		System.out.println(result);
	}
}
