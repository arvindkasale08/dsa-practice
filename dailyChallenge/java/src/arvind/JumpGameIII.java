package arvind;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int[] visited = new int[n];
        // lets do a bfs
        Queue<Integer> queue = new LinkedList<>();
        // add the start to the queue
        queue.offer(start);
        // mark the start as visited
        visited[start] = 1;

        if (arr[start] == 0)
            return true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            visited[i] = 1;
            if (arr[i] == 0)
                return true;
            int forwardIdx = i + arr[i];
            int backIdx = i - arr[i];
            if (forwardIdx >=0 && forwardIdx < n && visited[forwardIdx] == 0) {
                visited[forwardIdx] = 1;
                queue.offer(forwardIdx);
            }
            if (backIdx >=0 && backIdx < n && visited[backIdx] == 0) {
                visited[backIdx] = 1;
                queue.offer(backIdx);
            }
        }
        // we never reached a zero and have traversed all possible places.
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 0, 2, 1, 2};
        int start = 2;
        JumpGameIII solution = new JumpGameIII();
        boolean result = solution.canReach(arr, start);
        System.out.println(result);
    }
}
