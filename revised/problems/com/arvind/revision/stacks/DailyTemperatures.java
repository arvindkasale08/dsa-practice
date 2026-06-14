package com.arvind.revision.stacks;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i=1; i< temperatures.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int idx = stack.pop();
                    res[idx] = i - idx;
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {73,74,75,71,69,72,76,73};
        DailyTemperatures solution = new DailyTemperatures();
        int[] res = solution.dailyTemperatures(arr);
        for (int r : res) {
            System.out.print(r + ", ");
        }
    }
}
