package arvind.neetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestStringArray {

    class StringNumberComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {

            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            int len = s1.length();
            for (int i=0; i<len; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 == c2) continue;
                return c1 - c2;
            }

            return 0;
        }
    }

    public String kthLargestNumber(String[] nums, int k) {
        // Reverse pq to store only k elements [i.e. Min Heap]
        PriorityQueue<String> pq = new PriorityQueue(k, new StringNumberComparator());

        for (String s : nums) {
            pq.add(s);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        String[] nums = {"3","6","7","10"};
        int k = 4;
        KthLargestStringArray solution = new KthLargestStringArray();
        String s = solution.kthLargestNumber(nums, k);
        System.out.println(s);
    }
}
