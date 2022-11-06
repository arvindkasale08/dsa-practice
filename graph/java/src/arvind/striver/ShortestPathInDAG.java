package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {

	public int[] findPath(int V, int[][] edges) {
		int src = 4;
		List<List<int[]>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
		}
		// do a toposort using dfs
		Stack<Integer> stack = new Stack<>();
		int[] visited = new int[V];
		for (int i=0; i<V; i++) {
			if (visited[i]==0) {
				dfs(i, graph, visited, stack);
			}
		}
		int[] distance = new int[V];
		// populate with max distance
		Arrays.fill(distance, -1);
		distance[src] = 0;
		while (stack.peek() != src) {
			stack.pop();
		}
		while (!stack.isEmpty()) {
			int node = stack.pop();
			for (int[] next : graph.get(node)) {
				int I = next[0];
				int weight = next[1];
				distance[I] = distance[I] == -1 ? distance[node] + weight : Math.min(distance[I], distance[node] + weight);
			}
		}
		return distance;
	}

	private void dfs(int i, List<List<int[]>> graph, int[] visited, Stack<Integer> stack) {
		visited[i] = 1;
		for (int[] next: graph.get(i)) {
			if (visited[next[0]] == 0) {
				visited[next[0]] = 1;
				dfs(next[0], graph, visited, stack);
			}
		}
		stack.push(i);
	}

	public static void main(String[] args) {
		ShortestPathInDAG solution = new ShortestPathInDAG();
		int V = 6;
		int[][] edges = new int[][] {
			{0, 1, 2},
			{1, 2, 3},
			{2, 3, 6},
			{0, 4, 1},
			{4, 2, 2},
			{4, 5, 4},
			{5, 3, 1}
		};
		int[] shortestPath = solution.findPath(V, edges);
		System.out.println(shortestPath);
	}
}
