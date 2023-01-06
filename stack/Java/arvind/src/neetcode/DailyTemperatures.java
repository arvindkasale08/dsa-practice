package neetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Node> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(temperatures[i], i));
                result[i] = 0;
                continue;
            }
            if (temperatures[i] <= stack.peek().val) {
                stack.push(new Node(temperatures[i], i));
                continue;
            }
            while (!stack.isEmpty() && stack.peek().val < temperatures[i]) {
                Node popped = stack.pop();
                result[popped.index] = i - popped.index;
            }
            stack.push(new Node(temperatures[i], i));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
        DailyTemperatures solution = new DailyTemperatures();
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }
}
