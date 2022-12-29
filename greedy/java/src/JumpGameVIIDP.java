public class JumpGameVIIDP {

	public boolean canReach(String s, int minJump, int maxJump) {
		char[] ch = s.toCharArray();
		int n = ch.length;
		int[] dp = new int[n];
		return canReach(0, n, ch, minJump, maxJump, dp);
	}

	private boolean canReach(int i, int n, char[] ch, int minJump, int maxJump, int[] dp) {
		if (i >= n-1)
			return true;
		if (dp[i] != 0) {
			return dp[i] == 1;
		}
		if (ch[i] == '1') {
			dp[i] = -1;
			return false;
		}

		for (int idx=minJump; idx<= maxJump; idx++) {
			if (canReach(idx + i, n , ch, minJump, maxJump, dp)) {
				if (idx + i < n) {
					dp[idx + i] = 1;
				}
				return true;
			}
		}
		dp[i] = -1;
		return false;
	}

	public static void main(String[] args) {
		JumpGameVIIDP solution = new JumpGameVIIDP();
		String s = "011110";
		int minJump = 2;
		int maxJump = 3;
		boolean result = solution.canReach(s, minJump, maxJump);
		System.out.println(result);
	}
}
