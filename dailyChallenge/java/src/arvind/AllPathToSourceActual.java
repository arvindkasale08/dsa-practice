package arvind;

import java.util.ArrayList;
import java.util.List;

public class AllPathToSourceActual {

	public List<List<Integer>> allPaths(int[][] edges) {
		int V = edges.length;
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int i=0; i<V; i++) {
			for (int node : edges[i]) {
				graph.get(i).add(node);
			}
		}
		List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, graph, result, list);
		return result;
	}

	private void dfs(int i, List<List<Integer>> graph, List<List<Integer>> result, List<Integer> list) {

		if (graph.get(i).isEmpty()) {
			result.add(new ArrayList<>(list));
		}

		for (int neighbor : graph.get(i)) {
			list.add(neighbor);
			dfs(neighbor, graph, result, list);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {{4,3,1},{3,2,4},{},{4},{}};
		AllPathToSourceActual solution = new AllPathToSourceActual();
		List<List<Integer>> result = solution.allPaths(graph);
		System.out.println(result);
	}
}
