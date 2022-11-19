package arvind.p1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> find(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		find(0, target, candidates, new ArrayList<Integer>(), result);
		return result;
	}

	private void find(int i, int target, int[] candidates, List<Integer> list, List<List<Integer>> result) {
		if (target < 0)
			return;
		if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int idx = i; idx < candidates.length; idx++) {
			if (idx > i && candidates[idx] == candidates[idx-1])
				continue;

			list.add(candidates[idx]);
			find(idx+1, target-candidates[idx],candidates, list, result);
			// backtrack
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		CombinationSumII solution = new CombinationSumII();
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> result = solution.find(candidates, target);
		System.out.println(result);
	}
}
