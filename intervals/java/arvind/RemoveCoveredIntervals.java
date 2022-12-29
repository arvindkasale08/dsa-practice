package arvind;

import java.util.Arrays;

public class RemoveCoveredIntervals {

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
		int count = 0;
		int n = intervals.length;
		int l = intervals[0][0];
		int h = intervals[0][1];
		for (int i=1; i< n; i++) {
			int[] interval = intervals[i];
			if (l <= interval[0] && h >= interval[1]) {
				count++;
			} else {
				if (interval[0] <= l && interval[1] >= h) {
					count++;
				}
				l = interval[0];
				h = interval[1];
			}
		}
		return n - count;
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,2},{1,4},{3,4}};
		RemoveCoveredIntervals solution = new RemoveCoveredIntervals();
		int count = solution.removeCoveredIntervals(intervals);
		System.out.println(count);
	}
}
