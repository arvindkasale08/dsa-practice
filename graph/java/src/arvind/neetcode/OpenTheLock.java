package arvind.neetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

	class Pair {
		String s;
		int steps;

		public Pair(String s, int steps) {
			this.s = s;
			this.steps = steps;
		}
	}

	public int openLock(String[] deadends, String target) {
		Set<String> visited = new HashSet<>();
		Queue<Pair> queue = new LinkedList<>();
		Set<String> deadendsSet = new HashSet<>();
		for (String s : deadends) {
			deadendsSet.add(s);
		}

		if (deadendsSet.contains("0000"))
			return -1;

		// offer the first value
		queue.offer(new Pair("0000", 0)); // p q r s steps
		visited.add("0000");

		while(!queue.isEmpty()) {
			Pair node = queue.poll();
			String s = node.s;
			int steps = node.steps;

			if (target.equals(s)) {
				return steps;
			}

			int[] DIR_X = new int[]{-1, 1};
			char[] ch = s.toCharArray();
			for (int k=0; k<2; k++) {
				int offset = DIR_X[k];
				for (int i=0; i<4; i++) {
					char originalChar = ch[i];
					int num = Integer.parseInt(String.valueOf(originalChar)) + offset;
					if (num > 9)
						num = 0;
					if (num < 0)
						num = 9;
					char newChar = String.valueOf(num).toCharArray()[0];
					ch[i] = newChar;
					String newStr = new String(ch);
					if (!visited.contains(newStr) && !deadendsSet.contains(newStr)) {
						visited.add(newStr);
						queue.offer(new Pair(newStr, steps+1));
					}
					ch[i] = originalChar;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		OpenTheLock solution = new OpenTheLock();
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		int minimumTurns = solution.openLock(deadends, target);
		System.out.println(minimumTurns);
	}
}
