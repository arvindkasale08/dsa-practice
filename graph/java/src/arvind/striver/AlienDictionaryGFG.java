package arvind.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionaryGFG {

	public String findOrder(int V, String[] str) {
		List<int[]> edges = new ArrayList<>();
		findEdges(edges, str);
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[V];
		for (int i=0; i<V; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			indegree[edge[1]]+=1;
		}
		StringBuilder result = new StringBuilder();
		bfs(graph, indegree, result);
		return result.toString();
	}

	private void bfs(List<List<Integer>> graph, int[] indegree, StringBuilder result) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i=0; i< indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int I = queue.poll();
			char c = (char)(I + (int)'a');
			result.append(c);
			for (int next : graph.get(I)) {
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
	}

	private void findEdges(List<int[]> edges, String[] str) {
		int i=0;
		int j =1;
		while(j < str.length) {
			char[] s1 = str[i].toCharArray();
			char[] s2 = str[j].toCharArray();
			int ci = 0;
			int cj = 0;
			while (ci < s1.length && cj < s2.length) {
				if (s1[ci] == s2[cj]) {
					ci++;
					cj++;
				} else {
					int e1 = s1[ci] - 'a';
					int e2 = s2[cj] - 'a';
					edges.add(new int[] {e1, e2});
					i++;
					j++;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		AlienDictionaryGFG alienDictionary = new AlienDictionaryGFG();
		int K = 4; // number of nodes
		String[] str = {"baa","abcd","abca","cab","cad"};
		String order = alienDictionary.findOrder(K, str);
		System.out.println(order);
	}
}
