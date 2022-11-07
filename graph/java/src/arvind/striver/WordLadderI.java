package arvind.striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {

	class Pair {
		String s;
		int level;

		public Pair(String s, int level) {
			this.s = s;
			this.level = level;
		}
	}

	public int findShortestPath(String begin, String end, String[] wordlist) {
		Set<String> words = new HashSet<>();
		for (String s : wordlist) {
			words.add(s);
		}
		if (!words.contains(end))
			return 0;

		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(begin, 1));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			String s = pair.s;
			int level = pair.level;

			List<String> possibleStrs = getPossible(s, words);
			for (String str : possibleStrs) {
				if (str.equals(end))
					return level + 1;
				queue.offer(new Pair(str, level + 1));
				words.remove(str);
			}
		}

		return 0;
	}

	private List<String> getPossible(String s, Set<String> words) {
		List<String> possible = new ArrayList<>();
		int idx = 0;
		int finish = s.length();
		for (int i=0; i< finish; i++) {
			StringBuilder builder = new StringBuilder(s);
			for (int x=0; x < 27; x++) {
				char ch = (char)('a' + x);
				builder.setCharAt(i, ch);
				if (words.contains(builder.toString())) {
					possible.add(builder.toString());
				}
			}
		}
		return possible;
	}
	public static void main(String[] args) {
		WordLadderI solution = new WordLadderI();
		String[] wordlist = new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
		String begin = "hit";
		String end = "cog";
		int length = solution.findShortestPath(begin, end, wordlist);
		System.out.println(length);
	}
}
