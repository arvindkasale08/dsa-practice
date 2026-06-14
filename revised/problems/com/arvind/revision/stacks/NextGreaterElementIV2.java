package com.arvind.revision.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreaterElementIV2 {

    public List<Integer> nextLargerElement(List<Integer> arr) {
        int[] res = new int[arr.size()];
        Stack<Integer> stack = new Stack<>();
        // initialize
        res[arr.size()-1] = -1;
        stack.push(arr.get(arr.size() - 1));
        for (int i=arr.size()-2; i>=0; i--) {
            int current = arr.get(i);
            while (!stack.isEmpty() && current >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(current);
        }

        return Arrays.stream(res).boxed().toList();
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(13, 7, 6, 12);
        NextGreaterElementIV2 solution = new NextGreaterElementIV2();
        List<Integer> res = solution.nextLargerElement(lst);
        for (int r : res) {
            System.out.print(r + ", ");
        }

    }
}
