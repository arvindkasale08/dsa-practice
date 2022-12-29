package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		List<int[]> result = new ArrayList<>();
		int l = intervals[0][0];
		int h = intervals[0][1];

		for (int i=1; i<intervals.length; i++) {
			int[] interval = intervals[i];
			if (h < interval[0]) {
				result.add(new int[]{l, h});
				l = interval[0];
				h = interval[1];
			} else {
				l = Math.min(interval[0], l);
				h = Math.max(interval[1], h);
			}
		}
		result.add(new int[] {l, h});

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
		MergeIntervals solution = new MergeIntervals();
		int[][] result = solution.merge(intervals);
		for (int[] r : result) {
			System.out.println(Arrays.toString(r));
		}
	}
}
