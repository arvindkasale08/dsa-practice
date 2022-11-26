package arvind.neetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinDaysToEatOranges {

	public int minDays(int n) {
		int[] visited = new int[n+1];

		// oranges, days
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {n, 0});
		visited[n] = 1;
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int oranges = node[0];
			int days = node[1];
			visited[oranges] = 1;

			if (oranges == 0)
				return days;

			// reduce oranges by 1
			int newOranges = oranges - 1;
			if (visited[newOranges] == 0) {
				visited[newOranges] = 1;
				queue.offer(new int[] {newOranges, days+1});
			}
			// reduce oranges by 2
			if (oranges % 2 == 0) {
				newOranges = oranges - oranges / 2;
				if (visited[newOranges] == 0) {
					visited[newOranges] = 1;
					queue.offer(new int[] {newOranges, days+1});
				}
			}
			// reduce oranges by 3
			if (oranges % 3 == 0) {
				newOranges = oranges - (2 * (oranges/3));
				if (visited[newOranges] == 0) {
					visited[newOranges] = 1;
					queue.offer(new int[] {newOranges, days+1});
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int n = 10;
		MinDaysToEatOranges solution = new MinDaysToEatOranges();
		int minDays = solution.minDays(n);
		System.out.println(minDays);
	}
}
