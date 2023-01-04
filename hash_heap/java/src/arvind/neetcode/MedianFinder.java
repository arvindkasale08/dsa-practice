package arvind.neetcode;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> left; // mqx heap

    private PriorityQueue<Integer> right; // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int lcount = left.size();
        int rcount = right.size();
        if (lcount == 0 && rcount == 0) {
            left.offer(num);
            return;
        }
        if (left.peek() >= num) {
            // put in left
            left.offer(num);
            if (lcount > rcount) {
                right.offer(left.poll());
            }
        } else {
            // put in right
            right.offer(num);
            if (rcount > lcount) {
                left.offer(right.poll());
            }
        }
    }

    public double findMedian() {
        int lcount = left.size();
        int rcount = right.size();
        if (lcount == rcount) {
            return ((double) left.peek() + (double) right.peek()) / 2;
        } else if (lcount > rcount) {
            return (double) left.peek();
        } else {
            return (double) right.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(12);
        System.out.println(solution.findMedian());
        solution.addNum(10);
        System.out.println(solution.findMedian());
        solution.addNum(13);
        System.out.println(solution.findMedian());
        solution.addNum(11);
        System.out.println(solution.findMedian());
        solution.addNum(5);
        System.out.println(solution.findMedian());
        solution.addNum(15);
        System.out.println(solution.findMedian());
    }
}
