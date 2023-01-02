package arvind.neetcode;

import java.util.PriorityQueue;

public class KthLargestInStream {

    private PriorityQueue<Integer> queue;
    private int size;

    public KthLargestInStream(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.offer(val);
        } else {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestInStream kthLargest = new KthLargestInStream(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
