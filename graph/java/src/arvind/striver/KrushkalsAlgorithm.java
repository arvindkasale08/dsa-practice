package arvind.striver;

import java.util.Arrays;

public class KrushkalsAlgorithm {

	class DisjointSet {
		private int[] parent;
		private int[] size;
		private int V;

		public DisjointSet(int V) {
			this.V = V;
			this.parent = new int[V+1];
			this.size = new int[V+1];

			for (int i=0; i<=V; i++) {
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
			if (pu == pv) return;
			if (size[pu] < size[pv]) {
				parent[pu] = pv;
				size[pv] += size[pu];
			} else {
				parent[pv] = pu;
				size[pu] += size[pv];
			}
		}
	}


	public int findMSTWeight(int[][] edges, int V) {
		Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
		DisjointSet set = new DisjointSet(V);
		int sum = 0;

		for (int[] edge : edges) {
			int pu = set.findParent(edge[0]);
			int pv = set.findParent(edge[1]);
			if (pu != pv) {
				set.unionBySize(edge[0], edge[1]);
				sum += edge[2];
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		KrushkalsAlgorithm solution = new KrushkalsAlgorithm();
		int V = 6;
		int[][] edges = new int[][] {
			{5, 4, 9},
			{5, 1, 4},
			{1, 4, 1},
			{4, 3, 5},
			{4, 2, 3},
			{1, 2, 2},
			{2, 3, 3},
			{3, 6, 8},
			{2, 6, 7}
		};
		int weight = solution.findMSTWeight(edges, V);
		System.out.println(weight);
	}
}
