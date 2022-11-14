package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

    public List<List<Integer>> find(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int[] used = new int[arr.length];
        find(0, arr, new ArrayList(), used, result);
        return result;
    }

    private void find(int index, int[] arr, List<Integer> list, int[] used, List<List<Integer>> result) {
        if (list.size() == arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=0; i<arr.length; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && arr[i] == arr[i-1] && used[i-1] == 1)
                continue;
            used[i] = 1;
            list.add(arr[i]);
            find(index+1, arr, list, used, result);
            used[i] = 0;
            list.remove(list.size()-1);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        PermutationII solution = new PermutationII();
        int[] arr = {0, 1, 0, 0, 9};
        List<List<Integer>> result = solution.find(arr);
        System.out.println(result);
    }
}
