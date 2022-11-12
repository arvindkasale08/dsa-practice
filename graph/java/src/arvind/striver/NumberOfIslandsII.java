package arvind.striver;

import java.util.ArrayList;
import java.util.List;

/**
 * Use DSU
 */
public class NumberOfIslandsII {

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

	public List<Integer> findNumberOfIslands(int[][] moves, int m, int n) {
		DisjointSet ds = new DisjointSet(m*n);
		int[][] visited = new int[m][n];
		int count = 0;
		List<Integer> result = new ArrayList<>();
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};

		for (int[] move : moves) {
			int i = move[0];
			int j = move[1];
			if (visited[i][j] == 0) {
				visited[i][j] = 1;
				count+=1;
				int node = findNode(i, j, m, n);
				for (int k=0; k<4; k++) {
					int newI = i + DIR_I[k];
					int newJ = j + DIR_J[k];
					if (newI >=0 && newI < m && newJ >=0 && newJ < n && visited[newI][newJ] == 1) {
						int neigh = findNode(newI, newJ, m, n);
						int pu = ds.findParent(node);
						int pv = ds.findParent(neigh);
						if (pu != pv) {
							ds.unionBySize(node, neigh);
							count-=1;
						}
					}
				}
			}
			result.add(count);
		}
		return result;
	}

	private int findNode(int i, int j, int m, int n) {
		return (i * n) + j;
	}

	public static void main(String[] args) {
		NumberOfIslandsII solution = new NumberOfIslandsII();
		int[][] moves = new int[][] {
			{0, 0},
			{0, 0},
			{1, 1},
			{1, 0},
			{0, 1},
			{0, 3},
			{1, 3},
			{0, 4},
			{3, 2},
			{2, 2},
			{1, 2},
			{0, 2}
		};
		int m = 4;
		int n = 5;
		solution.findNumberOfIslands(moves, m, n);
	}
}
