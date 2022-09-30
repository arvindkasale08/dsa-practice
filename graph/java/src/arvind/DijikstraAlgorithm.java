package arvind;

import java.util.*;

public class DijikstraAlgorithm {

    class Node implements Comparator<Node> {
        private int v;
        private int weight;

        public Node() {}

        public Node (int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.weight < node2.weight)
                return -1;
            if (node1.weight > node2.weight)
                return 1;
            return 0;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", weight=" + weight +
                    '}';
        }
    }

    private int size;
    private List<List<Node>> graph;

    public DijikstraAlgorithm(int size) {
        this.size = size;
        this.graph = new ArrayList<>();
        for (int i=0; i<size; i++) {
            this.graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        this.graph.get(src).add(new Node(dest, weight));
        this.graph.get(dest).add(new Node(src, weight));
    }

    public int[] findShortestDistance(int size, List<List<Node>> graph, int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>(size, new Node());
        int[] distance = new int[size];
        for (int i=0; i<size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node vertex = pq.poll();

            for (Node neighbor : graph.get(vertex.getV())) {
                if ( neighbor.getWeight() + distance[vertex.v] < distance[neighbor.getV()]) {
                    distance[neighbor.getV()] = distance[vertex.v] + neighbor.getWeight();
                    pq.add(new Node(neighbor.getV(), distance[neighbor.getV()]));
                }
            }
        }
        return distance;
    }


    public static void main(String[] args) {
        DijikstraAlgorithm solution = new DijikstraAlgorithm(5);
        solution.addEdge(0, 1, 2);
        solution.addEdge(0, 3, 1);
        solution.addEdge(1, 2, 4);
        solution.addEdge(3, 2, 3);
        solution.addEdge(1, 4, 5);
        solution.addEdge(2, 4, 1);

        System.out.println(solution.graph);

        // find shortest distance for each node from source=0;
        int[] result = solution.findShortestDistance(solution.size, solution.graph, 0); // size, graph, source
        System.out.println("Result is "+ Arrays.toString(result));
    }

}
