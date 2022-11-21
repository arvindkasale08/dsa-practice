package arvind.p1;

public class SplitStringWorking {

	public boolean isValid(String str) {
		return isValid(0, str, (long)10e11);
	}

	private boolean isValid(int from, String str, long prev) {
		if (from == str.length())
			return true;

		for (int i=from; i<str.length(); i++) {
			long now=0;
			try {
				now = Long.parseLong(str.substring(from, i + 1));
			} catch (NumberFormatException ex) {
				return false;
			}
			if (now == prev-1) {
				if (isValid(i+1, str, now)) return true;
			}
			if (now >= prev) {
				return false;
			}
			if (i == str.length()-1) {
				return false;
			}
			if (prev !=(long)10e11 && now < prev) {
				continue;
			}
			if (isValid(i+1, str, now)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "99999999999999999998";
		SplitStringWorking solution = new SplitStringWorking();
		boolean isValid = solution.isValid(str);
		System.out.println(isValid);
	}
}
