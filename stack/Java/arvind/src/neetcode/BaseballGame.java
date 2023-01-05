package neetcode;

import java.util.Stack;

public class BaseballGame {

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int n = operations.length;
        for (int i=0; i<n; i++) {
            String s = operations[i];
            if (s.length() == 1) {
                // is char (c or D or is +)
                char ch = s.charAt(0);
                if (ch == 'C') {
                    stack.pop();
                } else if (ch == 'D') {
                    stack.push(stack.peek() * 2);
                } else if (ch == '+') {
                    int temp = stack.pop();
                    int temp2 = stack.peek();
                    stack.push(temp);
                    stack.push(temp + temp2);
                } else {
                    stack.push(Character.getNumericValue(ch));
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.stream().mapToInt(value -> value).sum();
    }

    public static void main(String[] args) {
        BaseballGame solution = new BaseballGame();
        String[] operations = {"5","2","C","D","+"};
        int points = solution.calPoints(operations);
        System.out.println(points);
    }
}
