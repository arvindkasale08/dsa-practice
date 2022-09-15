package arvind;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> find(int[] arr, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        find(arr, 0, target, k, list, result);
        return result;
    }

    public void find(int[] arr, int start, int target, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k && target == 0) {
            result.add(new ArrayList<>(list));
        }
        if (list.size() > k || target < 0) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            list.add(arr[i]);
            find(arr, i + 1, target - arr[i], k, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3();
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int k = 3;
        List<List<Integer>> result = solution.find(arr, target, k);
        System.out.println(result);
    }
}
