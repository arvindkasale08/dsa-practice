import java.util.Stack;

public class ValidParanthesisStringStacks {

	public boolean isValid(String s) {
		Stack<Integer> op = new Stack<>();
		Stack<Integer> stars = new Stack<>();
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				op.push(i);
			} else if (ch == ')') {
				if (!op.isEmpty()) {
					op.pop();
				} else if (!stars.isEmpty()) {
					stars.pop();
				} else {
					return false;
				}
			} else {
				// add to stars stack
				stars.push(i);
			}
		}

		// if there are any pending op ( and * try to see if they can match
		while (!op.isEmpty() && !stars.isEmpty()) {
			if (stars.peek() > op.peek()) {
				stars.pop();
				op.pop();
			} else {
				return false;
			}
		}

		return op.isEmpty();
	}

	public static void main(String[] args) {
		String s = "(((((*)))**";
		ValidParanthesisStringStacks solution = new ValidParanthesisStringStacks();
		boolean result = solution.isValid(s);
		System.out.println(result);
	}
}
