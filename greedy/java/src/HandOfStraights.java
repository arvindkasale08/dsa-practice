import java.util.HashMap;
import java.util.PriorityQueue;

public class HandOfStraights {

	public boolean isNStraightHand(int[] hand, int groupSize) {
		int n = hand.length;
		if (n % groupSize != 0)
			return false;
		HashMap<Integer, Integer> counts = new HashMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int h : hand) {
			if (!counts.containsKey(h)) {
				counts.put(h, 0);
				queue.offer(h);
			}
			counts.put(h, counts.get(h) + 1);
		}

		while (!queue.isEmpty()) {
			int min = queue.peek();
			if (!counts.containsKey(min)) {
				queue.poll();
				continue;
			}

			for (int i= min; i< min+groupSize; i++) {
				if (!counts.containsKey(i))
					return false;
				int newCount = counts.get(i) - 1;
				if (newCount == 0) {
					counts.remove(i);
					continue;
				}
				counts.put(i, newCount);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] hand = new int[] {1, 2, 3, 6, 2, 3, 4, 7, 8};
		int groupSize = 3;
		HandOfStraights solution = new HandOfStraights();
		boolean result = solution.isNStraightHand(hand, groupSize);
		System.out.println(result);
	}
}
