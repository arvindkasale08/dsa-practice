package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public List<String> find(int n) {
		List<String> results = new ArrayList<>();
		find(0, 0, 0, n, "", results);
		return results;
	}

	private void find(int i, int open, int closed, int n, String result, List<String> results) {
		if (open == closed && closed == n) {
			results.add(result);
			return;
		}
		if (closed > open || closed > n || open > n) {
			return;
		}

		find(i+1, open+1, closed, n, result+ "(", results);
		find(i+1, open, closed+1, n, result+ ")", results);
	}

	public static void main(String[] args) {
		GenerateParanthesis solution = new GenerateParanthesis();
		int n = 3;
		List<String> result = solution.find(n);
		System.out.println(result);
	}
}
