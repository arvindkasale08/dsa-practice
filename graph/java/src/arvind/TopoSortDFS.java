package arvind;

import java.util.*;

public class TopoSortDFS {

    private int size;
    private Map<Integer, List<Integer>> graph;

    public TopoSortDFS(int size) {
        this.size = size;
        this.graph = new HashMap<>();
        for (int i=0; i<size; i++) {
            this.graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.graph.get(src).add(dest);
    }

    public List<Integer> dfs() {
        int[] visited = new int[size];
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<size; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                result.add(i);
                dfs(graph, i, visited, result);
            }
        }
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int vertex, int[] visited, List<Integer> result) {

        for (Integer neighbor : graph.get(vertex)) {
            if (visited[neighbor] == 0) {
                result.add(neighbor);
                visited[neighbor] = 1;
                dfs(graph, neighbor, visited, result);
            }
        }
    }

    public List<Integer> topoSort() {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[size];
        for (int i=0; i<size; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                topoSort(graph, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void topoSort(Map<Integer, List<Integer>> graph, int vertex, int[] visited, Stack<Integer> stack) {

        for (Integer neighbor : graph.get(vertex)) {
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1;
                topoSort(graph, neighbor, visited, stack);
            }
        }
        // push only after all children and their children and their children have been added
        stack.push(vertex);
    }

    public static void main(String[] args) {
        TopoSortDFS solution = new TopoSortDFS(6);
        solution.addEdge(5, 0);
        solution.addEdge(4, 0);
        solution.addEdge(4, 1);
        solution.addEdge(5, 2);
        solution.addEdge(2, 3);
        solution.addEdge(3, 1);

        List<Integer> result = solution.dfs();
        System.out.println("DFS results are " + result);

        List<Integer> result2 = solution.topoSort();
        System.out.println("TopoSort results are "+ result2);
    }
}
