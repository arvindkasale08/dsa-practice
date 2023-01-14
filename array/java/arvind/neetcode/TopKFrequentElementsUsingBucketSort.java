package arvind.neetcode;

import java.util.*;

public class TopKFrequentElementsUsingBucketSort {

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int n = nums.length;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[n+1];

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            int count = entry.getValue();
            int val = entry.getKey();
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(val);
        }
        int j =0;
        for (int i=n; i>0; i--) {
            if (bucket[i] != null) {
                for (Integer val : bucket[i]) {
                    if (j < k) {
                        res[j] = val;
                        j++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElementsUsingBucketSort solution = new TopKFrequentElementsUsingBucketSort();
        int[] nums = {1};
        int k = 1;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
