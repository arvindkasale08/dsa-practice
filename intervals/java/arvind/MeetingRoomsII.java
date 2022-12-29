package arvind;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {

	public int find(int[][] intervals) {
		int n = intervals.length;
		int[] startIndex = new int[n];
		int[] endIndex = new int[n];

		for(int i=0; i<n; i++) {
			startIndex[i] = intervals[i][0];
			endIndex[i] = intervals[i][1];
		}
		Arrays.sort(startIndex);
		Arrays.sort(endIndex);
		int i = 0;
		int j = 0;
		int maxCount = 0;
		int count = 0;
		while (i < n && j < n) {
			if (startIndex[i] < endIndex[j]) {
				count += 1;
				i++;
			} else {
				count -= 1;
				j++;
			}
			maxCount = Math.max(count, maxCount);
		}

		if (j < n) {
			count-=1;
			j++;
		}


		return maxCount;
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {{0,30},{5,10},{15,20}};
		MeetingRoomsII solution = new MeetingRoomsII();
		int rooms = solution.find(intervals);
		System.out.println(rooms);
	}
}
