package arvind.neetcode;

import java.util.PriorityQueue;

public class LongestHappyString {

    class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        if (a != 0)
        pq.offer(new Node('a', a));
        if (b != 0)
        pq.offer(new Node('b', b));
        if (c != 0)
        pq.offer(new Node('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            Character last = null;
            Character secondLast = null;
            if (sb.length() >= 2) {
                last = sb.charAt(sb.length()-1);
                secondLast = sb.charAt(sb.length()-2);
            }
            if (last != null && node.c == last && node.c == secondLast) {
                if (pq.isEmpty()) {
                    break;
                }
                Node second = pq.poll();
                sb.append(second.c);
                second.count -= 1;
                pq.offer(node);
                if (second.count > 0)
                    pq.offer(second);
            } else {
                sb.append(node.c);
                node.count -= 1;
                if (node.count > 0)
                    pq.offer(node);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a=7, b=1, c= 0;
        LongestHappyString solution = new LongestHappyString();
        String output = solution.longestDiverseString(a, b, c);
        System.out.println(output);
    }
}
