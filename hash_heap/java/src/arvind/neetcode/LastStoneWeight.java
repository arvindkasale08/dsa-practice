package arvind.neetcode;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int diff = Math.abs(stone1 - stone2);
            if (diff != 0) {
                pq.offer(diff);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        LastStoneWeight solution = new LastStoneWeight();
        int[] stones = new int[] {2, 7, 4, 1, 8, 1};
        int stone = solution.lastStoneWeight(stones);
        System.out.println(stone);
    }
}
