package arvind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum1 {


    private void findCombinationSum(int[] arr, int target, List<Integer> list, List<List<Integer>> result, int j) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i=j; i<arr.length; i++) {
            list.add(arr[i]);
            findCombinationSum(arr, target - arr[i], list, result, i);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> findCombinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findCombinationSum(arr, target, list, result, 0);
        return result;
    }

    public static void display(List<List<Integer>> result) {
        for (List<Integer> l : result) {
            for (Integer i : l) {
                System.out.print(i+ " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        // expected outputs 2,2,3 and 7
        List<List<Integer>> result = new CombinationSum1().findCombinationSum(arr, target);
        display(result);
    }
}
