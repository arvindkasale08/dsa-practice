package arvind;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	public boolean canAttend(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

		int l = intervals[0][0];
		int h = intervals[0][1];
		for (int i=1; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (interval[0] < h) {
				return false;
			}
			l = interval[0];
			h = interval[1];
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{0,15},{5,10},{15,20}};
		MeetingRooms solution = new MeetingRooms();
		boolean result = solution.canAttend(intervals);
		System.out.println(result);
	}
}
