package arvind;

import java.util.Arrays;

public class MaximumBagsWithFullCapacity {

	public int find(int[] cap, int[] rocks, int additionalRocks) {
		int n = cap.length;
		int[] diff = new int[n];
		for (int i=0; i<n; i++) {
			diff[i] = cap[i] - rocks[i];
		}
		int count = 0;
		Arrays.sort(diff);

		for (int i=0; i<n; i++) {
			if (diff[i] == 0) {
				count++;
			} else {
				if (diff[i] <= additionalRocks) {
					additionalRocks -= diff[i];
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] cap = new int[] {2, 3, 4, 5};
		int[] rocks = new int[] {1, 2, 4, 4};
		int additionalRocks = 2;

		MaximumBagsWithFullCapacity solution = new MaximumBagsWithFullCapacity();
		int res = solution.find(cap, rocks, additionalRocks);
		System.out.println(res);
	}
}
