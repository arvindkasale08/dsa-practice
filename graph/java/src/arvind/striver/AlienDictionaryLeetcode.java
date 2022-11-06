package arvind.striver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AlienDictionaryLeetcode {

	public static void main(String[] args) {
		AlienDictionaryLeetcode solution = new AlienDictionaryLeetcode();
		String[] str = {"abc","ab"};

		String order = solution.findOrder(str);
		System.out.println(order);
	}

	public String findOrder(String[] str) {
		if (str.length == 1) {
			TreeSet<Character> set = new TreeSet();
			for (char c : new StringBuilder(str[0]).reverse().toString().toCharArray()) {
				set.add(c);
			}
			return set.stream()
				.map(String::valueOf)
				.collect(Collectors.joining());
		}
		List<char[]> edges = new ArrayList<>();
		Set<Character> nodes = new HashSet<>();
		boolean isValid = findEdges(edges, str, nodes);
		if (!isValid) {
			return "";
		}
		int V = nodes.size();
		Map<Character, List<Character>> graph = new HashMap<>();
		Map<Character, Integer> indegree = new HashMap<>();
		for (char c : nodes) {
			graph.put(c, new ArrayList<>());
			indegree.put(c, 0);
		}
		for (char[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			indegree.put(edge[1], indegree.get(edge[1]) + 1);
		}
		if (edges.isEmpty() && str.length == 2 && str[0].length() > str[1].length()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		bfs(graph, indegree, result);
		return result.length() == V ? result.toString() : "";
	}

	private void bfs(Map<Character, List<Character>> graph, Map<Character, Integer> indegree, StringBuilder result) {
		Queue<Character> queue = new LinkedList<>();
		for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
			if (entry.getValue() == 0) {
				queue.offer(entry.getKey());
			}
		}

		while (!queue.isEmpty()) {
			char c = queue.poll();
			result.append(c);
			for (char next : graph.get(c)) {
				indegree.put(next, indegree.get(next) - 1);
				if (indegree.get(next) == 0) {
					queue.offer(next);
				}
			}
		}
	}

	private boolean findEdges(List<char[]> edges, String[] str, Set<Character> nodes) {
		int i=0;
		int j =1;
		while(j < str.length) {
			char[] s1 = str[i].toCharArray();
			char[] s2 = str[j].toCharArray();
			int ci = 0;
			int cj = 0;
			boolean lastEqual = false;
			while (ci < s1.length && cj < s2.length) {
				if (s1[ci] == s2[cj]) {
					nodes.add(s1[ci]);
					lastEqual = true;
					ci++;
					cj++;
				} else {
					lastEqual = false;
					nodes.add(s1[ci]);
					nodes.add(s2[cj]);
					edges.add(new char[] {s1[ci], s2[cj]});
					break;
				}
			}
			if (ci < s1.length) {
				if (lastEqual)
					return false;
				while (ci < s1.length) {
					nodes.add(s1[ci]);
					ci++;
				}
			}
			if (cj < s2.length) {
				while (cj < s2.length) {
					nodes.add(s2[cj]);
					cj++;
				}
			}
			i++;
			j++;
		}
		return true;
	}
}
