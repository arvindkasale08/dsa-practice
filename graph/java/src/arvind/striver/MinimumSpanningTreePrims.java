package arvind.striver;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTreePrims {

    class Node {
        int n;
        int d;
        // parent
        int p;

        public Node(int n, int d, int p) {
            this.n = n;
            this.d = d;
            this.p = p;
        }
    }
    public int findMSTWeight(int V, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i=0; i< V; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[1], edge[2], -1));
            graph.get(edge[1]).add(new Node(edge[0], edge[2], -1));
        }
        int[] visited = new int[V];

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);

        queue.offer(new Node(0, 0, -1));
        int sum = 0;
        int[][] mstEdges = new int[V-1][2];
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int n = node.n;
            int d = node.d;
            int p = node.p;

            if (visited[n] == 0) {
                sum+=d;
                if (p != -1) {
                    mstEdges[count][0] = n;
                    mstEdges[count][1] = p;
                    count+=1;
                }
                for (Node next : graph.get(n)) {
                    if (visited[next.n] == 0) {
                        queue.offer(new Node(next.n, next.d, n));
                    }
                }
                visited[n] = 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MinimumSpanningTreePrims solution = new MinimumSpanningTreePrims();
        int V = 5;
        int[][] edges = new int[][] {
                {0, 1, 2},
                {0, 2, 1},
                {1, 2, 1},
                {2, 4, 2},
                {2, 3, 2},
                {4, 3, 1}
        };
        int weight = solution.findMSTWeight(V, edges);
        System.out.println(weight);
    }
}
