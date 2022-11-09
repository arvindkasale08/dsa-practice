package arvind.striver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplications {

	class Node implements Comparable<Node> {
		int n;
		int l;

		public Node(int n, int l) {
			this.n = n;
			this.l = l;
		}

		@Override
		public int compareTo(Node o) {
			return 0;
		}

	}

	public int minMultiplications(int start, int end, int[] arr) {
		int[] seen = new int[100001];
		if (start == end )
			return 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {start, 0});

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int num = node[0];
			int level = node[1];

			for (int mul : arr) {
				if (seen[num] == 0) {
					int ans = (mul * num) % 100000;
					int nextlevel = level + 1;
					if (ans == end)
						return nextlevel;
					queue.offer(new int[]{ans, nextlevel});
				}

			}
			seen[num] = 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		MinimumMultiplications solution = new MinimumMultiplications();
		int start = 3;
		int end = 100;
		int[] arr = {50, 100, 150};

		int result = solution.minMultiplications(start, end, arr);
		System.out.println(result);
	}
}
