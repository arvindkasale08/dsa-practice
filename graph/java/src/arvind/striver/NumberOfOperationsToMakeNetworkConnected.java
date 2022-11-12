package arvind.striver;

public class NumberOfOperationsToMakeNetworkConnected {

	class DisjointSet {

		private int[] parent;
		private int[] size;
		private int redundantEdge;
		private int V;

		public DisjointSet(int V) {
			parent = new int[V+1];
			size = new int[V+1];
			redundantEdge = 0;
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

		public int numberOfBosses() {
			int count = 0;
			// 1 indexed
			for (int i=1; i< parent.length; i++) {
				if (i == parent[i])
					count++; // this is a top most parent.
			}
			return count;
		}

	}

	public int findConnections(int V, int[][] edges) {
		DisjointSet set = new DisjointSet(V);
		for (int[] edge : edges) {
			set.unionBySize(edge[0], edge[1]);
		}
		int noOfComponents = set.numberOfBosses();
		return set.redundantEdge >= noOfComponents-1 ? noOfComponents-1 : -1;
	}

	public static void main(String[] args) {
		int[][] edges = new int[][] {
			{0, 1},
			{0, 3},
			{0, 2},
			{1, 2},
			{2, 3},
			{4, 5},
			{5, 6},
			{7, 8}
		};
		int V = 9;
		NumberOfOperationsToMakeNetworkConnected solution = new NumberOfOperationsToMakeNetworkConnected();
		int noOfConnections = solution.findConnections(V, edges);
		System.out.println(noOfConnections);
	}
}
