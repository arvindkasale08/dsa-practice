package arvind.striver;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TopoSortDFS {

	public List<Integer> findTopologicalSort(int V, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}
		int[] visited = new int[V];
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<V; i++) {
			if (visited[i] == 0) {
				dfs(i, graph, visited, stack);
			}
		}
		List<Integer> result = new ArrayList<>();
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;
	}

	private void dfs(int i, List<List<Integer>> graph, int[] visited, Stack<Integer> stack) {
		visited[i] = 1;
		for (int next : graph.get(i)) {
			if (visited[next] == 0) {
				dfs(next, graph, visited, stack);
			}
		}
		stack.push(i);
	}

	public static void main(String[] args) {
		TopoSortDFS solution = new TopoSortDFS();
		int V = 6;
		int[][] edges = new int[][] {
			{5, 0},
			{4, 0},
			{5, 2},
			{4, 1},
			{2, 3},
			{3, 1}
		};
		List<Integer> result = solution.findTopologicalSort(V, edges);
		System.out.println(result);
	}
}
