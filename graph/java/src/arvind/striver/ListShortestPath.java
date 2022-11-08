package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ListShortestPath {

	class Node implements Comparable<Node> {
		int n;
		int w;
		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if (this.w > o.w) {
				return 1;
			}
			if (this.w < o.w) {
				return -1;
			}
			return 0;
		}
	}

	public List<Integer> findPath(int V, int[][] edges) {
		List<List<Node>> graph = new ArrayList<>();
		for (int i=0; i<=V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] l : edges) {
			graph.get(l[0]).add(new Node(l[1], l[2]));
			graph.get(l[1]).add(new Node(l[0], l[2]));
		}
		int src = 1;
		int dest = V;
		int[] distance = new int[V+1];
		Arrays.fill(distance, -1);
		distance[src] = 0;
		int[] parent = new int[V+1];
		for (int i=0; i<=V; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			for (Node next : graph.get(node.n)) {
				if (distance[next.n] == -1 || distance[next.n] > node.w + next.w) {
					distance[next.n] = node.w + next.w;
					parent[next.n] = node.n;
					pq.offer(new Node(next.n, distance[next.n]));
				}
			}
		}

		if (distance[dest] == -1)
			return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		int i = V;
		while (parent[i] != i) {
			result.add(i);
			i = parent[i];
		}
		result.add(src);

		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		ListShortestPath solution = new ListShortestPath();
		int V = 5;
		int[][] edges = new int[][] {
			{1, 2, 2},
			{2, 5, 5},
			{2, 3, 4},
			{1, 4, 1},
			{4, 3, 3},
			{3, 5, 1}
		};
		List<Integer> path = solution.findPath(V, edges);
		System.out.println(path);
	}
}
