public class ValidParanthesisStringRecursion {

	public boolean checkValidString(String s) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		// index, arr, open, closed
		return check(0, n, ch, 0, 0);
	}

	private boolean check(int idx, int n, char[] ch, int open, int closed) {
		if (closed > open)
			return false;
		if (idx == n) {
			return open == closed;
		}
		if (ch[idx] == '(') {
			if (check(idx+1, n, ch, open + 1, closed)) return true;
		} else if (ch[idx] == ')') {
			if (check(idx+1, n, ch, open, closed + 1)) return true;
		} else {
			if (check(idx+1, n, ch, open + 1, closed)) return true;
			if (check(idx+1, n, ch, open, closed + 1)) return true;
			if (check(idx+1, n, ch, open, closed)) return true;
		}
		return false;
	}
}
