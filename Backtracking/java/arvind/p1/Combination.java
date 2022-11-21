package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	public List<List<Integer>> solve(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		find(0, n, k, new ArrayList<>(), result);
		return result;
	}

	private void find(int start, int n, int k, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == k) {
			result.add(new ArrayList<>(list));
		}

		for (int i = start+1; i<= n; i++) {
			list.add(i);
			find(i, n, k, list, result);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		Combination solution = new Combination();
		List<List<Integer>> result = solution.solve(n, k);
		System.out.println(result);
	}
}
