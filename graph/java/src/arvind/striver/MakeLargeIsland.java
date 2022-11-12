package arvind.striver;

import java.util.HashSet;
import java.util.Set;

public class MakeLargeIsland {

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

		public int getSize(int u) {
			int pu = findParent(u);
			return size[pu];
		}

	}

	public int find(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int V = m * n;
		DisjointSet ds = new DisjointSet(V);
		// create the disjoint set
		int[] DIR_I = {0, 1};
		int[] DIR_J = {1, 0};
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == 1) {
					int node = getNode(i, j, m, n);
					for (int k=0; k<2; k++) {
						int newI = i + DIR_I[k];
						int newJ = j + DIR_J[k];
						if (newI < m && newJ < n && grid[newI][newJ] == 1) {
							int neigh = getNode(newI, newJ, m, n);
							ds.unionBySize(node, neigh);
						}
					}
				}
			}
		}
		int[] DIR_X = {-1, 0, 1, 0};
		int[] DIR_Y = {0, 1, 0, -1};
		int maxCount = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				int count = 1;
				if (grid[i][j] == 0) {
					int node = getNode(i, j, m, n);
					Set<Integer> neighboringComponents = new HashSet<>();
					for (int k=0; k<4; k++) {
						int newI = i + DIR_X[k];
						int newJ = j + DIR_Y[k];
						if (newI >= 0 && newI < m && newJ >=0 && newJ < n && grid[newI][newJ] == 1) {
							int neigh = getNode(newI, newJ, m, n);
							int pu = ds.findParent(neigh);
							neighboringComponents.add(pu);
						}
					}
					for (int pu : neighboringComponents) {
						count += ds.getSize(pu);
					}
				}
				maxCount = Math.max(maxCount, count);
			}
		}

		return maxCount;
	}

	private int getNode(int i, int j, int m, int n) {
		return (n* i) + j;
	}

	public static void main(String[] args) {
		int[][] grid = new int[][] {
			{1, 1, 0, 1, 1},
			{1, 1, 0, 1, 1},
			{1, 1, 0, 1, 1},
			{0, 0, 1, 0, 0},
			{0, 0, 1, 1, 1},
			{0, 0, 1, 1, 1}
		};

		MakeLargeIsland solution = new MakeLargeIsland();
		int count = solution.find(grid);
		System.out.println(count);
	}
}
