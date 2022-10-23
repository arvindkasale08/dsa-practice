package arvind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 * this cant be memoized as array index could be -1 so may be use an hashmap
 */
public class TargetSum {

	public int countWays(int[] arr, int target) {
		int n = arr.length;
		Map<String, Integer> dp = new HashMap();
		return countWays(arr, n-1, target, dp);
	}

	private int countWays(int[] arr, int index, int target, Map<String, Integer> dp) {

		if (index == 0) {
			if (Math.abs(arr[0]) == Math.abs(target)) {
				return 1;
			} else {
				return 0;
			}
		}

		//if (dp.containsKey(index + "_" + target)) return dp.get(index + "_" +target);

		int add = countWays(arr , index - 1, target - arr[index], dp);
		int sub = countWays(arr, index -1, target + arr[index], dp);

		int ans = add + sub;
		dp.put(index + "_"+ target, ans);
		return ans;
	}

	public static void main(String[] args) {
		TargetSum solution = new TargetSum();
		int[] arr = {0,0,0,0,0,0,0,0,1};
		int target = 1;
		int ways = solution.countWays(arr, target);
		System.out.println(ways);
	}
}
