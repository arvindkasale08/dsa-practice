package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaxProbability {

    class Node {
        int v;
        double p;

        public Node(int v, double p) {
            this.v = v;
            this.p = p;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Node(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Node(edge[0], succProb[i]));
        }

        double[] visited = new double[n];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.p, o1.p));
        pq.offer(new Node(start, 1.00000d));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node neighbour : graph.get(node.v)) {
                double np = node.p * neighbour.p;
                int nv = neighbour.v;
                if (visited[nv] < np) {
                    visited[nv] = np;
                    pq.offer(new Node(nv, np));
                }
            }
        }
        return visited[end];
    }

    public static void main(String[] args) {
        int n= 5;
        int[][] edges = new int[][] {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double[] succProb = new double[] {0.37,0.17,0.93,0.23,0.39,0.04};
        int start = 3;
        int end = 4;
        PathWithMaxProbability solution = new PathWithMaxProbability();
        System.out.println(solution.maxProbability(n, edges, succProb, start, end));
    }
}
