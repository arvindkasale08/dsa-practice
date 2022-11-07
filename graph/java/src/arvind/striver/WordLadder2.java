package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

	public List<List<String>> findLadder(String begin, String end, String[] wordlist) {
		Set<String> words = new HashSet<>();
		List<List<String>> result = new ArrayList<>();
		for (String s : wordlist) {
			words.add(s);
		}
		if (!words.contains(end)) {
			return new ArrayList<>();
		}
		Queue<List<String>> queue = new LinkedList<>();
		queue.offer(Arrays.asList(begin));

		String removal = begin;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				List<String> vals = queue.poll();
				String val = vals.get(vals.size()-1);
				List<String> possible = getPossible(val, words);
				for (String s : possible) {
					List<String> newlist = new ArrayList<>(vals);
					newlist.add(s);
					queue.offer(newlist);
					if (s.equals(end)) {
						result.add(newlist);
					}
				}
			}
			if (!result.isEmpty()) {
				return result;
			}
			words.remove(removal);
		}
		return new ArrayList<>();
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
		WordLadder2 solution = new WordLadder2();
		String[] wordList = {"pat", "bot", "pot", "poz", "coz"};
		String begin = "bat";
		String end = "coz";
		List<List<String>> result = solution.findLadder(begin, end, wordList);
		System.out.println(result);
	}
}
