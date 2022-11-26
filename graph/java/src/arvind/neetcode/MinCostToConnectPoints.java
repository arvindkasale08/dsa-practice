package arvind.neetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectPoints {

    class Node {
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        // create a graph containing edges of all nodes to another
        int V = points.length;
        List<List<Node>> graph = new ArrayList<>();
        for (int i=0; i<V; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if (i!= j) {
                    int xi = points[i][0];
                    int yi = points[i][1];
                    int xj = points[j][0];
                    int yj = points[j][1];
                    int d = Math.abs(xi - xj) + Math.abs(yi - yj);
                    graph.get(i).add(new Node(j, d));
                }
            }
        }

        // Now Apply prims
        // All I need is a visited array and a Priority Queue
        int[] visited = new int[V];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.offer(new int[] {0, 0});
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int d = node[0];
            int n = node[1];

            if (visited[n] == 0) {
                sum += d;

                for (Node neighbor : graph.get(n)) {
                    if (visited[neighbor.v] == 0) {
                        queue.offer(new int[]{neighbor.d, neighbor.v});
                    }
                }
                visited[n] = 1;
            }
        }


        return sum;
    }

    public static void main(String[] args) {
        MinCostToConnectPoints solution = new MinCostToConnectPoints();
        int[][] points = new int[][] {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int cost = solution.minCostConnectPoints(points);
        System.out.println(cost);
    }
}
