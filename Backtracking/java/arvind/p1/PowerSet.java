package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public List<List<Integer>> find(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		find(0, arr, new ArrayList<>(), result);
		return result;
	}

	private void find(int i, int[] arr, List<Integer> list, List<List<Integer>> result) {
		if (i == arr.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		// pick
		list.add(arr[i]);
		find(i+1, arr, list, result);
		// dont pick
		list.remove(list.size()-1);
		find(i+1, arr, list, result);
	}

	public static void main(String[] args) {
		PowerSet solution = new PowerSet();
		int[] arr = {1, 2, 3};
		List<List<Integer>> result = solution.find(arr);
		System.out.println(result);
	}
}
