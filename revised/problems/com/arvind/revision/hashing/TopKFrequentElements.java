package com.arvind.revision.hashing;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> countToVal = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (!countToVal.containsKey(entry.getValue())) {
                countToVal.put(entry.getValue(), new ArrayList<>());
            }
            countToVal.get(entry.getValue()).add(entry.getKey());
        }
        int count = 0;
        for (int i=nums.length; i>=0; i--) {
            if (countToVal.containsKey(i)) {
                for (Integer n : countToVal.get(i)) {
                    if (count < k) {
                        result[count] = n;
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k = 2;
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] arr = solution.topKFrequent(nums, k);
        CommonUtils.print(arr);
    }
}
