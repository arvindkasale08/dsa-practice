package arvind.striver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

	public List<Integer> findPath(int V, int[][] prereq) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[V];
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : prereq) {
			graph.get(edge[1]).add(edge[0]);
			indegree[edge[0]]+=1;
		}
		List<Integer> result = new ArrayList<>();
		bfs(graph, indegree, result);
		return result.size() == V ? result : new ArrayList<>();
	}

	private void bfs(List<List<Integer>> graph, int[] indegree, List<Integer> result) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i< indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int I = queue.poll();
			result.add(I);
			for (int next : graph.get(I)) {
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		CourseScheduleII solution = new CourseScheduleII();
		int V = 4;
		int[][] prereq = new int[][] {
			{1, 0},
			{2, 0},
			{3, 1},
			{3, 2},
			//{0, 3} to make a cycle
		};
		List<Integer> result = solution.findPath(V, prereq);
		System.out.println(result);
	}
}
