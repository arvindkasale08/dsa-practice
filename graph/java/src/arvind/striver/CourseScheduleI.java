package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {

	public boolean isPossible(int V, int[][] prereq) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : prereq) {
			graph.get(edge[1]).add(edge[0]);
		}
		// requirements converted to graph format
		int[] visited = new int[V];
		int[] pathvisited = new int[V];

		for (int i=0; i<V; i++) {
			if (dfs(i, graph, visited, pathvisited)) return false;
		}
		return true;
	}

	private boolean dfs(int i, List<List<Integer>> graph, int[] visited, int[] pathvisited) {
		visited[i] = 1;
		pathvisited[i] = 1;
		for (int next : graph.get(i)) {
			if (visited[next] == 0) {
				visited[next] = 1;
				if (dfs(next, graph, visited, pathvisited)) return true;
			} else if (pathvisited[next] == 1) {
				return true;
			}
		}
		pathvisited[i] = 0;
		return false;
	}

	public static void main(String[] args) {
		CourseScheduleI solution = new CourseScheduleI();
		int V = 4;
		int[][] prereq = new int[][] {
			{1, 0},
			{2, 0},
			{3, 1},
			{3, 2},
			//{0, 3}
		};
		boolean flag = solution.isPossible(V, prereq);
		System.out.println(flag);
	}
}
