package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> find(int k, int target) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<List<Integer>> result = new ArrayList<>();
		find(0, target, k, arr, new ArrayList<Integer>(), result);
		return result;
	}

	private void find(int idx, int target, int k, int[] arr, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == k && target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		if (list.size() > k || target < 0)
			return;

		for (int i=idx; i<arr.length; i++) {
			list.add(arr[i]);
			find(i + 1, target - arr[i], k, arr, list, result);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int k = 3;
		int n = 7;
		CombinationSumIII solution = new CombinationSumIII();
		List<List<Integer>> result = solution.find(3, 7);
		System.out.println(result);
	}
}
