package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class MostStonesRemoved {

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

		public int stonesRemoved() {
			List<Integer> up = new ArrayList<>();
			for (int i=0; i<parent.length; i++) {
				if (i == parent[i]) {
					up.add(i);
				}
			}

			int stonesRemoved = 0;
			for (int p : up) {
				stonesRemoved += size[p] - 1;
			}
			return stonesRemoved;
		}



	}

	public int findRemovedStones(int[][] stones) {
		int m = 0;
		int n = 0;
		for (int[] stone : stones) {
			m = Math.max(m, stone[0]);
			n = Math.max(n, stone[1]);
		}
		m+=1;
		n+=1;
		int[][] grid = new int[m][n];
		for (int[] stone : stones) {
			grid[stone[0]][stone[1]] = 1;
		}
		DisjointSet ds = new DisjointSet(m * n);

		for (int i=0; i< m; i++) {
			for (int j=0; j<n ; j++) {
				if (grid[i][j] == 1) {
					// find first left and top element;
					int newI = i - 1;
					int newJ = j -1;
					int node = getNode(i, j, m, n);
					while (newI >=0) {
						if (grid[newI][j] == 1) {
							int newNode = getNode(newI, j, m, n);
							ds.unionBySize(node, newNode);
							break;
						}
						newI--;
					}
					while (newJ >=0) {
						if (grid[i][newJ] == 1) {
							int newNode = getNode(i, newJ, m, n);
							ds.unionBySize(node, newNode);
							break;
						}
						newJ--;
					}
				}
			}
		}

		return ds.stonesRemoved();
	}

	private int getNode(int i, int j, int m, int n) {
		return (n * i) + j;
	}

	public static void main(String[] args) {
		MostStonesRemoved solution = new MostStonesRemoved();
		int[][] stones = new int[][] {
			{1, 2},
			{1, 3},
			{3, 3},
			{3, 1},
			{2, 1},
			{1, 0}
		};
		int removed = solution.findRemovedStones(stones);
		System.out.println(removed);

	}
}
