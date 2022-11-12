package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AccountMerge {

	class DisjointSet {

		private int[] parent;
		private int[] size;
		private int redundantEdge;
		private int V;

		public DisjointSet(int V) {
			parent = new int[V];
			size = new int[V];
			redundantEdge = 0;
			for (int i=0; i<V; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public int findParent(int u) {
			if (u == parent[u])
				return u;
			return parent[u] = findParent(parent[u]);
		}

		public void unionBySize(int u, int v) {
			int pu = findParent(u);
			int pv = findParent(v);
			if (pu == pv) {
				// redundant edge
				redundantEdge+=1;
				return;
			}
			if (size[pu] < size[pv]) {
				parent[pu] = pv;
				size[pv] += size[pu];
			} else {
				parent[pv] = pu;
				size[pu] += size[pv];
			}
		}

	}

	public List<List<String>> mergeAccounts(List<List<String>> input) {
		int V = input.size();
		DisjointSet ds = new DisjointSet(V);
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		for (int node=0; node<input.size(); node++) {
			for (int email = 1; email<input.get(node).size(); email++) {
				if (map.containsKey(input.get(node).get(email))) {
					ds.unionBySize(map.get(input.get(node).get(email)), node);
					continue;
				}
				map.put(input.get(node).get(email), node);
			}
		}
		List<String>[] emailList = new ArrayList[V];

		for (int i=0; i<V; i++) {
			emailList[i] = new ArrayList<>();
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String email = entry.getKey();
			int u = entry.getValue();
			int pu = ds.findParent(u);
			emailList[pu].add(email);
		}
		List<List<String>> result = new ArrayList<>();
		for (int i=0; i< V; i++) {
			if (emailList[i].size() == 0) continue;
			String name = input.get(i).get(0);
			Collections.sort(emailList[i]);
			List<String> res = new ArrayList<>();
			res.add(name);
			for (String email : emailList[i]) {
				res.add(email);
			}
			result.add(res);
		}

		return result;
	}

	public static void main(String[] args) {
		AccountMerge solution = new AccountMerge();
		List<List<String>> input = new ArrayList<>();
		input.add(Arrays.asList("John", "j1", "j2", "j3"));
		input.add(Arrays.asList("John", "j4"));
		input.add(Arrays.asList("Raj", "r1", "r2"));
		input.add(Arrays.asList("John", "j1", "j5"));
		input.add(Arrays.asList("Raj", "r2", "r0"));
		input.add(Arrays.asList("Mary", "m1"));

		List<List<String>> result = solution.mergeAccounts(input);
		System.out.println(result);

	}
}
