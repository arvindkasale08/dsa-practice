package arvind.neetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1]; // result array
        int ri = 0; // result index
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i< n; i++) {

            // remove everything out of window
            if (!deque.isEmpty() && deque.peek() <= i-k) {
                deque.poll();
            }

            // remove everything that is smaller from the end
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }


            deque.offer(i);

            if (i >= k-1) {
                res[ri] = arr[deque.peek()];
                ri+=1;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] res = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
