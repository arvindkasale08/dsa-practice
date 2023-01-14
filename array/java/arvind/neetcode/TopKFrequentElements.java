package arvind.neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    class Node {
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }
        int i=0;
        while (i < k) {
            res[i] = pq.poll().val;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
