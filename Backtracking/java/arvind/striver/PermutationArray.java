package arvind.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationArray {

    public List<int[]> find(int[] arr) {
        List<int[]> result = new ArrayList<>();
        find(0, arr, result);
        return result;
    }

    private void find(int index, int[] arr, List<int[]> result) {
        if (index == arr.length) {
            result.add(Arrays.copyOf(arr, arr.length));
        }
        for (int i=index; i<arr.length; i++) {
            swap(arr, index, i);
            find(index+1, arr, result);
            swap(arr, index, i);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        PermutationArray solution = new PermutationArray();
        int[] arr = {1, 2, 3};
        List<int[]> result = solution.find(arr);
        System.out.println(result);
    }
}
