import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVIIGreedyBFS {

	public boolean canReach(String s, int minJump, int maxJump) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		int maxSoFar = -1;
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			if (idx == n-1) {
				return true;
			}
			for (int i= minJump; i <= maxJump; i++) {
				if (i + idx < n && ch[i+idx] == '0' && i + idx > maxSoFar) {
					queue.offer(i + idx);
					maxSoFar = Math.max(maxSoFar, i+idx);
				}
 			}
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGameVIIGreedyBFS solution = new JumpGameVIIGreedyBFS();
		String s = "011110";
		int minJump = 2;
		int maxJump = 3;
		boolean result = solution.canReach(s, minJump, maxJump);
		System.out.println(result);
	}
}
