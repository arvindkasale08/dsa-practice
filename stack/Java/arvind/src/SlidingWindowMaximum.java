import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    // TC O(N*k)
    public int[] solveBF(int[] arr, int k) {
        int n = arr.length;
        int[] maxArray = new int[n-k+1];
        // runs almost n times
        for (int i=0; i < n-k+1; i++) {
            int max = arr[i];
            int j = k;
            // runs k times
            while (j > 0) {
                max = Math.max(max, arr[i+j-1]);
                j--;
            }
            maxArray[i] = max;
        }
        return maxArray;
    }

    public int[] solve(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n-k+1];
        int ri = 0;
        // store indexes in a deque
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0; i< n; i++) {
            // remove out of range indexes
            if (!q.isEmpty() && q.peek() == i-k) {
                q.poll();
            }

            // remove smaller numbers in k range as they are of no use
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k-1) {
                result[ri++] = arr[q.peek()];
            }
        }
        return result;
    }

    public void display(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.solveBF(arr, k);
        int[] result2 = solution.solve(arr, k);
        solution.display(result);
        solution.display(result2);
    }
}
