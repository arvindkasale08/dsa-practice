import java.util.*;
public class ValidParenthesis {
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "()]{}";
        if (isValid(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
