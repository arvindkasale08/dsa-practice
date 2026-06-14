package com.arvind.revision.stacks;

import java.util.Iterator;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;

        for (int ast : asteroids) {
            // left moving asteroid
            if (ast < 0) {
                boolean currBroken = false;
                while (!stack.isEmpty() && !currBroken) {
                    int peeked = stack.peek();
                    if (peeked < 0) break;
                    if (Math.abs(ast) < peeked) {
                        currBroken = true;
                        break;
                    } else if (Math.abs(ast) == peeked) {
                      currBroken = true;
                      stack.pop();
                    } else {
                        stack.pop();
                    }
                }
                if (!currBroken) {
                    stack.push(ast);
                }
            } else {
                stack.push(ast);
            }
        }
        int[] res = new int[stack.size()];
        Iterator<Integer> itr = stack.iterator();
        int i = 0;
        while (itr.hasNext()) {
            res[i] = itr.next();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, -6, 2, -1, 4};
        int[] arr2 = new int[] {10, 2, -5};
        int[] arr3 = new int[] {8, -8};
        AsteroidCollision solution = new AsteroidCollision();

        int[] res = solution.asteroidCollision(arr);
        int[] res2 = solution.asteroidCollision(arr3);
        for (int r : res) {
            System.out.print(r + ", ");
        }
        System.out.println("\n#######################");
        for (int r : res2) {
            System.out.print(r + ", ");
        }
        System.out.println("\n#######################");
    }
}
