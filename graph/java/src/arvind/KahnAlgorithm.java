package arvind;

import java.util.*;

public class KahnAlgorithm {

    private int size;
    private Map<Integer, List<Integer>> graph;

    public KahnAlgorithm(int size) {
        this.size = size;
        this.graph = new HashMap<>();
        for (int i=0; i<size; i++) {
            this.graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.graph.get(src).add(dest);
    }

    public List<Integer> topoSort() {
        // calculate indegree.
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] in_degree = new int[this.size];
        for (List<Integer> list : this.graph.values()) {
            for (Integer l : list) {
                in_degree[l]+= 1;
            }
        }
        for (int i=0; i<size; i++) {
            if (in_degree[i] == 0) {
                result.add(i);
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int vertex = queue.poll();

            for (Integer neighbor : graph.get(vertex)) {
                in_degree[neighbor] -= 1;
                if (in_degree[neighbor] == 0) {
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KahnAlgorithm solution = new KahnAlgorithm(6);
        solution.addEdge(5, 0);
        solution.addEdge(4, 0);
        solution.addEdge(4, 1);
        solution.addEdge(5, 2);
        solution.addEdge(2, 3);
        solution.addEdge(3, 1);

        List<Integer> result = solution.topoSort();

        System.out.println(result);
    }
}
