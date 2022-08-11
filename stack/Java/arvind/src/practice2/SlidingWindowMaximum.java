package practice2;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] solve(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n-k+1];
        int ri = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i=0; i<n; i++) {

            if (!dq.isEmpty() && dq.peek() == i-k) {
                dq.poll();
            }

            // remove all smaller elements
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            dq.offer(i);
            if (i >= k-1) {
                result[ri++] = arr[dq.peek()];
            }
        }
        return result;
    }

    public static void display(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.solve(arr, k);
        display(result);
    }
}
