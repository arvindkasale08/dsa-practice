package arvind.neetcode;

import java.util.*;

public class NetworkDelayTime {

    class Node {
        int v;
        int w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int networkDelayTime(int V, int k, int[][] times) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }
        int[] distance = new int[V+1];
        Arrays.fill(distance, (int) 1e9);
        distance[k] = 0;

        // Do shortest path algoritm
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.offer(new int[] {0, k});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int n = node[1];
            int w = node[0];

            for (Node neighbor : graph.get(n)) {
                int newW = neighbor.w + w;
                if (distance[neighbor.v] > newW) {
                    distance[neighbor.v] = newW;
                    queue.offer(new int[]{newW, neighbor.v});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=1; i< distance.length; i++) {
            max = Math.max(distance[i], max);
        }
        return max == (int) 1e9 ? -1 : max;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int V = 4;
        int k = 2;

        NetworkDelayTime solution = new NetworkDelayTime();
        int delay = solution.networkDelayTime(V, k, times);
        System.out.println(delay);
    }
}
