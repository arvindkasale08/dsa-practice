package arvind.neetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	class Task {
		char t;
		int count;

		public Task() {
			this.t = t;
			this.count = count;
		}
	}

	public int leastInterval(char[] tasks, int n) {
		HashMap<Character, Integer> countSet = new HashMap<>();
		for (char task : tasks) {
			if (!countSet.containsKey(task)) {
				countSet.put(task, 1);
			} else {
				countSet.put(task, countSet.get(task) + 1);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (Integer values : countSet.values()) {
			pq.offer(values);
		}
		Queue<int[]> queue = new LinkedList<>();
		int currentTime = 0;
		while (!pq.isEmpty() || !queue.isEmpty()) {
			if (!pq.isEmpty()) {
				int val = pq.poll();
				if (val -1 > 0) {
					queue.add(new int[]{val - 1, currentTime + n});
				}
			}
			if (!queue.isEmpty() && queue.peek()[1] == currentTime) {
				pq.offer(queue.poll()[0]);
			}
			currentTime+=1;
		}

		return currentTime;
	}

	public static void main(String[] args) {
		char[] tasks = new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int n = 2;
		TaskScheduler solution = new TaskScheduler();
		int result = solution.leastInterval(tasks, n);
		System.out.println(result);
	}
}
