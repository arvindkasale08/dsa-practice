package arvind.neetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int numberOfRooms = rooms.size();
		int visited[] = new int[numberOfRooms];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		visited[0] = 1;

		while (!queue.isEmpty()) {
			int room = queue.poll();
			visited[room] = 1;

			for (int i=0; i<numberOfRooms; i++) {
				List<Integer> rr = rooms.get(i);
				for (Integer r : rr) {
					if (visited[r] == 0) {
						visited[r] = 1;
						queue.offer(r);
					}
				}
			}
		}
		for (int i=0; i<numberOfRooms; i++) {
			if (visited[i] == 0)
				return false;
		}
		return true;
	}
}
