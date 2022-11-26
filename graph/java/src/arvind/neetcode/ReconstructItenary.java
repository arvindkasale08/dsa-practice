package arvind.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItenary {

	class Pair {
		String d;
		boolean visited;

		public Pair(String d, boolean visited) {
			this.d = d;
			this.visited = visited;
		}
	}

	class TicketComparator implements Comparator<String[]> {

		@Override
		public int compare(String[] o1, String[] o2) {
			if (o1[0].equals(o2[0])) {
				return o1[1].compareTo(o2[1]);
			}
			return o1[0].compareTo(o2[0]);
		}
	}

	public List<String> findItinerary(String[][] tickets) {
		Arrays.sort(tickets, new TicketComparator());
		Map<String, List<Pair>> graph = new HashMap<>();
		int n = tickets.length;

		for (String[] ticket : tickets) {
			if (!graph.containsKey(ticket[0])) {
				graph.put(ticket[0], new ArrayList<>());
			}
			graph.get(ticket[0]).add(new Pair(ticket[1], false));
		}

		// perform dfs
		List<String> list = new ArrayList<>();
		list.add("JFK");
		dfs("JFK", graph, n, list);
		return list;
	}

	private boolean dfs(String node, Map<String, List<Pair>> graph, int n, List<String> list) {

		if (list.size() == n+1) {
			return true;
		}
		if (graph.get(node) != null) {
			for (Pair neighbor : graph.get(node)) {
				if (!neighbor.visited) {
					list.add(neighbor.d);
					neighbor.visited = true;
					// do dfs
					if (dfs(neighbor.d, graph, n, list)) return true;
					neighbor.visited = false;
					list.remove(list.size() - 1);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ReconstructItenary solution = new ReconstructItenary();
		String[][] tickets = new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> result = solution.findItinerary(tickets);
		System.out.println(result);
	}
}
