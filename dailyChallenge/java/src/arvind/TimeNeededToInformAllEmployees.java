package arvind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int i=0; i<n; i++) {
            if (manager[i] != -1) {
                graph.get(manager[i]).add(i);
            }
        }

        int mins = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, headId} );

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[1];
            int d = node[0];


            for (int neighbour : graph.get(i)) {
                int newD = d + informTime[i];
                mins = Math.max(mins, newD);
                queue.offer(new int[] {newD, neighbour});
            }
        }

        return mins;
    }

    public static void main(String[] args) {
        TimeNeededToInformAllEmployees solution = new TimeNeededToInformAllEmployees();
        int n = 6;
        int headId = 2;
        int[] manager = new int[] {2, 2, -1, 2, 2, 2};
        int[] informTime = new int[] {0, 0, 1, 0, 0, 0};
        int mins = solution.numOfMinutes(n, headId, manager, informTime);
        System.out.println(mins);
    }
}
