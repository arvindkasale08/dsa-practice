package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumIntervalForEachQuery {

	public int[] minInterval(int[][] intervals, int[] queries) {
		Map<Integer, List<Integer>> queryIndexMap = new HashMap<>();
		for (int i=0; i<queries.length; i++) {
			if (!queryIndexMap.containsKey(queries[i])) {
				queryIndexMap.put(queries[i], new ArrayList<>());
			}
			queryIndexMap.get(queries[i]).add(i);
		}
		int n = queries.length;
		int[] result = new int[n];
		Arrays.fill(result, -1);
		Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
		Arrays.sort(queries);

		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});

		int intervalIdx = 0;
		for (int i= 0; i< queries.length; i++) {
			int query = queries[i];
			while (intervalIdx < intervals.length) {
				int[] interval = intervals[intervalIdx];
				int size = interval[1] - interval[0] + 1;
				int high = interval[1];
				if (interval[0] <= query) {
					queue.offer(new int[]{size, high, intervalIdx});
					intervalIdx++;
				} else {
					break;
				}
			}
			while (!queue.isEmpty()) {
				int[] node = queue.peek();
				int size = node[0];
				int index = node[2];
				int[] interval = intervals[index];
				if (interval[0] <= query && interval[1] >= query) {
					// its between a valid small interval
					for (int idx : queryIndexMap.get(query)) {
						result[idx] = size;
					}
					break;
				}
				if (interval[1] < query) {
					queue.poll();
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,4},{2,4},{3,6},{4,4}};
		int[] queries = new int[] {2, 3, 4, 5};
		MinimumIntervalForEachQuery solution = new MinimumIntervalForEachQuery();
		int[] result = solution.minInterval(intervals, queries);
		System.out.println(result);
	}
}
