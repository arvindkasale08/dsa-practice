package neetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class AsteroidCollisions {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;

        for (int i=0; i<n; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                int asteroid = asteroids[i];
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                    int element = stack.pop();
                    if (element == Math.abs(asteroid)) {
                        asteroid = -100000;
                        break;
                    }
                    if (element > Math.abs(asteroid)) {
                        asteroid = element;
                    }
                }
                if (asteroid != -100000)
                    stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        Iterator<Integer> itr = stack.iterator();
        int i = 0;
        while (itr.hasNext()) {
            result[i] = itr.next();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollisions solution = new AsteroidCollisions();
        int[] asteroids = {8, -8};
        int[] result = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));
    }
}
