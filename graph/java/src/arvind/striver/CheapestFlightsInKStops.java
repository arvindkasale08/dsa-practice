package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CheapestFlightsInKStops {

	class Node {
		int n;
		int w;
		public Node(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

	public int cheapestFlightDFS(int[][] flights, int src, int dest, int k) {
		Map<Integer, List<Node>> graph = new HashMap<>();
		for (int[] flight : flights) {
			if (!graph.containsKey(flight[0])) {
				graph.put(flight[0], new ArrayList<>());
			}
			graph.get(flight[0]).add(new Node(flight[1], flight[2]));
		}
		return find(graph, src, dest, k);
	}

	private int find(Map<Integer, List<Node>> graph, int node, int dest, int k) {
		if (k < 0) {
			if (node == dest) {
				return 0;
			}
			return 100000000;
		}
		if (node == dest) {
			return 0;
		}
		int cost = 100000000;

		for (Node next : graph.get(node)) {
			cost = Math.min(cost, (next.w + find(graph, next.n, dest, k-1)));
		}
		return cost;
	}

	public int cheapestFlight(int[][] flights, int src, int dest, int k) {
		Map<Integer, List<Node>> graph = new HashMap<>();
		Set<Integer> nodes = new HashSet<>();
		for (int[] flight : flights) {
			if (!graph.containsKey(flight[0])) {
				graph.put(flight[0], new ArrayList<>());
			}
			graph.get(flight[0]).add(new Node(flight[1], flight[2]));
			nodes.add(flight[0]);
			nodes.add(flight[1]);
		}
		int V = nodes.size();
		int[] distance = new int[V];
		Arrays.fill(distance, -1);

		Queue<int[]> queue = new LinkedList<>();
		// add the source
		queue.offer(new int[] {0, 0, src});

		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int stops = node[0];
			int cost = node[1];
			int i = node[2];

			if (i == dest) {
				continue;
			}

			for (Node next : graph.get(i)) {
				int newStops = stops + 1;
				int newCost = cost + next.w;

				if (newStops <= k+1) {
					if (distance[next.n] == -1 || newCost < distance[next.n]) {
						distance[next.n] = newCost;
					}
					queue.offer(new int[] {newStops, newCost, next.n});
				}
			}
		}

		return distance[dest];
	}

	public static void main(String[] args) {
		CheapestFlightsInKStops solution = new CheapestFlightsInKStops();
		int[][] flights = new int[][] {
			{0, 1, 100},
			{2, 0, 100},
			{1, 2, 100},
			{1, 3, 600},
			{2, 3, 200}
		};
		int src = 0;
		int dest = 3;
		int k = 1;

		int cost = solution.cheapestFlight(flights, src, dest, k);
		int cost2 = solution.cheapestFlightDFS(flights, src, dest, k);
		System.out.println(cost);
		System.out.println(cost2);
	}
}
