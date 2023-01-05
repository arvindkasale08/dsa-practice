package neetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.length() == 1) {
                char ch = s.charAt(0);
                if (ch == '+') {
                    stack.push(stack.pop() + stack.pop());
                } else if (ch == '-') {
                    stack.push(-(stack.pop() - stack.pop()));
                } else if (ch == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else if (ch == '/') {
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first / second);
                } else {
                    stack.push(Character.getNumericValue(ch));
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
        String[] tokens = new String[] {"2","1","+","3","*"};
        int result = solution.evalRPN(tokens);
        System.out.println(result);
    }
}
