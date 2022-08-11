import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        // is length even
        if (arr.length % 2 != 0) return false;
        // cant start with closing
        if (arr[0] == '}' || arr[0] == ')' || arr[0] == ']') return false;
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (stack.isEmpty())
                stack.push(c);
            else {
                if (c == '}' && stack.peek() == '{')
                    stack.pop();
                else if (c == ']' && stack.peek() == '[')
                    stack.pop();
                else if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParanthesis solution = new ValidParanthesis();
        //String input = "[[()]]";
        String input = "(){}}{";
        boolean isValid = solution.isValid(input);
        System.out.println(isValid);
    }
}
