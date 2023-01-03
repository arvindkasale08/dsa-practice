package arvind.neetcode;

import java.util.*;

public class ReorganizeString {

    class Node {
        char c;
        int count;
        int idx;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        Queue<Node> waitingq = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty() || !waitingq.isEmpty()) {
            while (!waitingq.isEmpty()) {
                if (waitingq.peek().idx > idx) {
                    break;
                }
                pq.offer(waitingq.poll());
            }

            if (pq.isEmpty())
                return "";

            Node n = pq.poll();
            sb.append(n.c);
            n.idx = idx+2;
            n.count -=1;
            if (n.count > 0) {
                waitingq.offer(n);
            }
            idx++;
        }

        return idx == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        ReorganizeString solution = new ReorganizeString();
        String s = "aaab";
        String output = solution.reorganizeString(s);
        System.out.println(output);
    }
}
