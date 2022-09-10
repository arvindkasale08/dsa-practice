package arvind.practice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {

    public List<List<Integer>> findCombination(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        findCombination(arr, target, result, list, 0);
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

    public void findCombination(int[] arr, int target, List<List<Integer>> result, List<Integer> list, int j) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i=j; i<arr.length; i++) {
            System.out.println(list+ " "+ arr[i]);
            list.add(arr[i]); // 2 2 2
            // recursion
            findCombination(arr, target - arr[i], result, list, i);
            list.remove(list.size()-1); // 2 2
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        CombinationSumOne solution = new CombinationSumOne();
        List<List<Integer>> result = solution.findCombination(arr, target);
        display(result);
    }
}
