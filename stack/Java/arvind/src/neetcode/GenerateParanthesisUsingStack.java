package neetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesisUsingStack {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        generateParenthesis(0, 0, n, stack, result);
        return result;
    }

    private void generateParenthesis(int open, int closed, int n, Stack<Character> stack, List<String> result) {
        if (open == closed && open == n) {
            StringBuilder sb = new StringBuilder();
            Iterator<Character> iterator = stack.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }

            result.add(sb.toString());
            return;
        }


        if (open < n) {
            stack.push('(');
            generateParenthesis(open+1, closed, n, stack, result);
            stack.pop();
        }

        if (closed < open) {
            stack.push(')');
            generateParenthesis(open, closed +1, n, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        GenerateParanthesisUsingStack solution = new GenerateParanthesisUsingStack();
        List<String> result = solution.generateParenthesis(n);
        System.out.println(result);
    }
}
