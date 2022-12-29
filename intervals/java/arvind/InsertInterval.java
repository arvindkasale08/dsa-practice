package arvind;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public int[][] insert(int[][] intervals, int[] newInterval) {
		int newLow = newInterval[0];
		int newHigh = newInterval[1];
		List<int[]> result = new ArrayList<>();
		int intHigh = 0;
		int intLow = 0;
		int count = 0;
		boolean intervalAdded = false;
		for (int i=0; i<intervals.length; i++) {
			int[] interval = intervals[i];
			intLow = interval[0];
			intHigh = interval[1];
			if (intHigh < newLow) {
				count++;
				result.add(interval);
			} else if (intLow > newHigh) {
				if (!intervalAdded) {
					result.add(new int[]{newLow, newHigh});
					count+=1;
					intervalAdded = true;
				}
				result.add(interval);
				count+= 1;
			} else {
				newLow = Math.min(newLow, intLow);
				newHigh = Math.max(newHigh, intHigh);
				if (i == intervals.length - 1 && !intervalAdded) {
					result.add(new int[] {newLow, newHigh});
					count++;
					intervalAdded = true;
				}
			}
		}
		if (intHigh < newLow) {
			result.add(newInterval);
			count++;
		}

		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals = new int[][] {};
		int[] newInterval = new int[] {5, 7};
		InsertInterval solution = new InsertInterval();
		int[][] result = solution.insert(intervals, newInterval);
		System.out.println(result);
	}
}
