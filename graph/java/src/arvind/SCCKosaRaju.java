package arvind;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SCCKosaRaju {

    private int size;
    private List<List<Integer>> graph;

    public SCCKosaRaju(int size) {
        this.size = size;
        this.graph = new ArrayList<>();
        for (int i=0; i<size; i++) {
            this.graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        // creating a directed edge
        this.graph.get(src).add(dest);
    }

    private void topo(List<List<Integer>> graph, int[] visited, int vertex, Stack<Integer> stack) {
        visited[vertex] = 1;
        for (Integer neighbor : graph.get(vertex)) {
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1;
                topo(graph, visited, neighbor, stack);
            }
        }
        stack.push(vertex);
    }

    public List<List<Integer>> findScc(int size, List<List<Integer>> graph) {
        // toposort karo dfs se using stack...
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[size];
        List<List<Integer>> results = new ArrayList<>();

        for (int i=0; i< size; i++) {
            if (visited[i] == 0) {
                topo(graph, visited, i, stack);
            }
        }
        System.out.println(stack);

        // find transpose
        List<List<Integer> > transpose = new ArrayList();

        for (int i = 0; i < size; i++)
            transpose.add(new ArrayList<Integer>());

        for(int i = 0;i<size;i++) {
            visited[i] = 0;
            for(Integer it: graph.get(i)) {
                transpose.get(it).add(i);
            }
        }

        System.out.println(transpose);

        // do rev dfs using stack elements as input (pop stack)

        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            List<Integer> list = new ArrayList<>();
            if (visited[vertex] == 0) {
                list.add(vertex);
                visited[vertex] = 1;
                dfs(transpose, vertex, list, visited);
            }
            if (!list.isEmpty()) {
                results.add(list);
            }
        }

        return results;
    }

    private void dfs(List<List<Integer>> transpose, int vertex, List<Integer> list, int[] visited) {
        visited[vertex] = 1;
        for (Integer neighbor : transpose.get(vertex)) {
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1;
                list.add(neighbor);
                dfs(transpose, neighbor, list, visited);
            }
        }
    }

    public static void main(String[] args) {
        SCCKosaRaju solution = new SCCKosaRaju(5);
        solution.addEdge(0, 1);
        solution.addEdge(1, 2);
        solution.addEdge(2, 0);
        solution.addEdge(1, 3);
        solution.addEdge(3, 4);

        System.out.println(solution.graph);
        List<List<Integer>> result = solution.findScc(solution.size, solution.graph);
        System.out.println(result);
    }
}
