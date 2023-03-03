package neetcode;

import java.util.Arrays;

public class StoneGame {

    public boolean stoneGameMemo(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int sum = Arrays.stream(piles).sum();
        int alicePile = stoneGameMemo(0, n-1, true, piles, memo);
        return alicePile > (sum - alicePile);
    }

    private int stoneGameMemo(int l, int r, boolean isAlicePlaying, int[] piles, int[][] memo) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }
        if (isAlicePlaying) {
            int takeLeft = piles[l] + stoneGameMemo(l+1, r, false, piles, memo);
            int takeRight = piles[r] + stoneGameMemo(l, r-1, false, piles, memo);
            return memo[l][r] = Math.max(takeLeft, takeRight);
        } else {
            int takeLeft = 0 + stoneGameMemo(l+1, r, true, piles, memo);
            int takeRight = 0 + stoneGameMemo(l, r-1, true, piles, memo);
            return memo[l][r] = Math.max(takeLeft, takeRight);
        }
    }

    public static void main(String[] args) {
        StoneGame solution = new StoneGame();
        int[] piles = {5, 3, 4, 5};
        boolean res = solution.stoneGameMemo(piles);
        System.out.println(res);
    }
}
