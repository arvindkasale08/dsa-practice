package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmCodingNinjas {

	class Node implements Comparable<Node> {
		int n;
		int w;

		public Node() {

		}

		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Node node2) {
			if (this.w < node2.w)
				return -1;
			if (this.w > node2.w)
				return 1;
			return 0;
		}
	}

	public int[] findDistance(int V, int[][] list, int src) {
		List<List<Node>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] l : list) {
			graph.get(l[0]).add(new Node(l[1], l[2]));
			graph.get(l[1]).add(new Node(l[0], l[2]));
		}
		int[] distance = new int[V];
		Arrays.fill(distance, -1);
		distance[src] = 0;

		PriorityQueue<Node> queue = new PriorityQueue<>();

		queue.add(new Node(src, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int n = node.n;
			int w = node.w;

			for (Node next : graph.get(n)) {
				int nextNode = next.n;
				int nextweight = next.w;
				if (distance[nextNode] == -1 || nextweight + distance[n] < distance[nextNode]) {
					distance[nextNode] = nextweight + distance[n];
					queue.add(new Node(nextNode, distance[nextNode]));
				}
			}

		}

		return distance;
	}

	public static void main(String[] args) {
		DijkstraAlgorithmCodingNinjas solution = new DijkstraAlgorithmCodingNinjas();
		int V = 4;
		int[][] list = new int[][] {
			{0, 1, 5},
			{0, 2, 8},
			{1, 2, 9},
			{1, 3, 2},
			{2, 3, 6}
		};
		int src = 0;
		int[] distance = solution.findDistance(V, list, src);
		System.out.println(distance);
	}
}
