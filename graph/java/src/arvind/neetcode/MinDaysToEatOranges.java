package arvind.neetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinDaysToEatOranges {

	public int minDays(int n) {
		int[] visited = new int[n];
		Arrays.fill(visited, (int)10e9);

		// oranges, days
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {10, 0});
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int oranges = node[0];
			int days = Math.min(visited[], node[1]);


			if (oranges == 0)
				return days;

			// do all stuff


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
