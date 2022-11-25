package arvind.neetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadder {

    public int snakesAndLadder(int[][] board) {
        int m = board.length;
        int n = m;
        Set<Integer> visited = new HashSet<>();

        // We will do BFS on first 6 nodes
        Queue<int[]> queue = new LinkedList<>();
        for (int i=2; i<=7; i++) {
            queue.offer(new int[] {i, 1});// number and moves;
            visited.add(i);
        }

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int steps = node[1];

            int[] ij = getIJ(x, m);
            int i = ij[0];
            int j = ij[1];
            if (board[i][j] != -1) {
                x = board[i][j];
            }
            if (x == m*n) {
                return steps;
            }
            int inc = 1;
            while (inc < 7) {
                int newX = x + inc;
                if (!visited.contains(newX) && newX <= m * n) {
                    visited.add(newX);
                    queue.offer(new int[] {newX, steps+1});
                }
                inc++;
            }
        }
        return -1;
    }

    private int[] getIJ(int x, int m) {
        boolean flipped = false;
        int i;
        int j;
        if (x % m == 0) {
            i = m - (x / m);
        } else {
            i = m - 1 - (x / m);
        }
        if ((m-i+1) % 2 != 0) {
            flipped = true;
        }
        if (x % m == 0) {
            j = flipped ? 0 : m - 1;
        } else {
            j = flipped ? (m-1) - (x%m-1): (x % m) - 1;
        }
        return new int[] {i, j};
    }

    public static void main(String[] args) {
        SnakesAndLadder solution = new SnakesAndLadder();
        int[][] board = new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int steps = solution.snakesAndLadder(board);
        System.out.println(steps);

        /*for (int i=1; i<=4; i++) {
            int[] test = solution.getIJ(i, 2);
            System.out.println(i+ ": "+ test[0]+ " "+ test[1]);
        }*/

    }
}
