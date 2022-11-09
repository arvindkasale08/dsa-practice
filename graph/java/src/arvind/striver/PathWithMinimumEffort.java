package arvind.striver;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

	class Node implements Comparable<Node> {
		int d;
		int i;
		int j;

		public Node(int d, int i, int j) {
			this.d = d;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Node o) {
			if (this.d > o.d)
				return 1;
			if (this.d < o.d)
				return -1;
			return 0;
		}
	}

	public int minEffort(int[][] maze) {
		int m = maze.length;
		int n = maze[0].length;
		int[][] distance = new int[m][n];
		for (int[] arr : distance) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(0, 0, 0));
		int[] DIR_I = {-1, 0, 1, 0};
		int[] DIR_J = {0, 1, 0, -1};

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int I = node.i;
			int J = node.j;
			int D = node.d;

			for (int k=0; k<4; k++) {
				int newI = I + DIR_I[k];
				int newJ = J + DIR_J[k];
				if (newI >=0 && newI < m && newJ >=0 && newJ < n) {
					int newD = Math.abs(maze[I][J] - maze[newI][newJ]);
					newD = newD < D ? D : newD;
					if (distance[newI][newJ] > newD) {
						distance[newI][newJ] = newD;
						queue.offer(new Node(newD, newI, newJ));
					}
				}
			}

		}

		return distance[m-1][n-1];
	}

	public static void main(String[] args) {
		PathWithMinimumEffort solution = new PathWithMinimumEffort();
		int[][] maze = new int[][] {
			{1, 2, 2},
			{3, 8, 2},
			{5, 3, 5}
		};
		int cost = solution.minEffort(maze);
		System.out.println(cost);
	}
}
