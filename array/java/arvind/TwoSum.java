package arvind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // TC: O(n2) SC: O(1)
    private int[] solveBF(int[] arr, int target) {

        for (int i=0; i<arr.length-1; i++) {
            for (int j=i; j< arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{ i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    // TC: O(nlogn) due to sorting most sorting algos use O(n) space as well
    // 2 pointers but only can be used if you return the value and not the index of elements
    private int[] solve2Pointers(int[] arr, int target) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;

        while(high > low) {
            if (arr[high] + arr[low] == target) {
                return new int[] {arr[low], arr[high]};
            }
            if (arr[high] + arr[low] < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[] {-1, -1};
    }

    // TC: O(n) and SC: O(n)
    private int[] solveHashMap(int[] arr, int target) {
        int[] result = new int[] {-1, -1};
        Map<Integer, Integer> ref = new HashMap<>();


        for (int i=0; i< arr.length; i++) {
            if (ref.containsKey(arr[i])) {
                return new int[] {ref.get(arr[i]), i};
            } else {
                ref.put(target - arr[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[] {2, 7, 4, 1, 11};
        int target = 8;
        int[] result = twoSum.solveBF(arr, target);
        System.out.println("The numbers are "+ result[0]+ ", "+ result[1]);

        TwoSum twoSum2 = new TwoSum();
        int[] arr2 = new int[] {2, 7, 4, 1, 11};
        int target2 = 8;
        int[] result2 = twoSum.solve2Pointers(arr2, target2);
        System.out.println("The numbers are "+ result2[0]+ ", "+ result2[1]);

        TwoSum twoSum3 = new TwoSum();
        int[] arr3 = new int[] {2, 7, 4, 1, 11};
        int target3 = 8;
        int[] result3 = twoSum.solveHashMap(arr3, target3);
        System.out.println("The numbers are "+ result3[0]+ ", "+ result3[1]);
    }
}
