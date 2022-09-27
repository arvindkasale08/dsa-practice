package arvind;

import java.util.*;

public class CheckIfGraphIsStronglyConnected {

    private int size;
    private Map<Integer, List<Integer>> graph;

    public CheckIfGraphIsStronglyConnected(int size) {
        this.size = size;
        this.graph = new HashMap<>();
        for (int i=0; i< size; i++) {
            this.graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.graph.get(src).add(dest);
    }

    private void dfs(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> visited) {
        visited.add(vertex);
        for (Integer neighbour : graph.get(vertex)) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                dfs(graph, neighbour, visited);
            }
        }
    }

    private Map<Integer, List<Integer>> transpose(Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
            Integer key = entry.getKey();
            for (Integer val : entry.getValue()) {
                if (!graph2.containsKey(val)) {
                    graph2.put(val, new ArrayList<>());
                }
                graph2.get(val).add(key);
            }
        }
        return graph2;
    }

    public boolean checkIfStronglyConnected() {
        Set<Integer> visited = new HashSet<>();
        // first dfs
        dfs(this.graph, 0, visited);
        if (visited.size() != size) return false;
        // transpose
        this.graph = transpose(this.graph);
        visited = new HashSet<>();
        //second dfs
        dfs(this.graph, 0, visited);
        if (visited.size() != size) return false;
        return true;
    }

    public static void main(String[] args) {
        CheckIfGraphIsStronglyConnected solution = new CheckIfGraphIsStronglyConnected(5);
        solution.addEdge(0, 1);
        solution.addEdge(1, 2);
        solution.addEdge(2, 3);
        solution.addEdge(3, 0);
        solution.addEdge(2, 4);
        solution.addEdge(4, 2);
        boolean isStronglyConnected = solution.checkIfStronglyConnected();
        System.out.println(isStronglyConnected);
    }
}
