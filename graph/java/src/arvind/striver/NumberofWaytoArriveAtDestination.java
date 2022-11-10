package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberofWaytoArriveAtDestination {

	class Node implements Comparable<Node>{
		int n;
		int w;

		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if (this.w > o.w)
				return 1;
			if (this.w < o.w)
				return -1;
			return 0;
		}
	}

	public int findNumberOfWaysToArrive(int V, int[][] roads) {
		List<List<Node>> graph = new ArrayList<>();
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] road : roads) {
			graph.get(road[0]).add(new Node(road[1], road[2]));
			graph.get(road[1]).add(new Node(road[0], road[2]));
		}
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		int[] ways = new int[V];
		ways[0] = 1;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));


		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int n = node.n;
			int w = node.w;

			for (Node next : graph.get(n)) {
				int newW =  w + next.w;
				if (distance[next.n] == newW) {
					ways[next.n] = ways[next.n] + ways[n];
				} else if (newW < distance[next.n]) {
					distance[next.n] = newW;
					ways[next.n] = ways[n];
					queue.offer(new Node(next.n, newW));
				}
			}
		}
		return ways[V-1];
	}

	public static void main(String[] args) {
		NumberofWaytoArriveAtDestination solution = new NumberofWaytoArriveAtDestination();
		int V = 7;
		int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		int ways = solution.findNumberOfWaysToArrive(V, roads);
		System.out.println(ways);
	}
}
