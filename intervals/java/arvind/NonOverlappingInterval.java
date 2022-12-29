package arvind;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

	public int erase(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
		int l = intervals[0][0];
		int h = intervals[0][1];
		int count = 0;

		for (int i=1; i< intervals.length; i++) {
			int[] interval = intervals[i];
			if (interval[0] < h) {
				count++;
				if (h > interval[1]) {
					l = interval[0];
					h = interval[1];
				}
			} else {
				l = interval[0];
				h = interval[1];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{0,2},{1,3},{2,4},{3,5},{4,6}};
		NonOverlappingInterval solution = new NonOverlappingInterval();
		int count = solution.erase(intervals);
		System.out.println(count);
	}
}
