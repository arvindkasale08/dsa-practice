package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumI {

    public List<Integer> find(int[] arr) {
        List<Integer> result = new ArrayList<>();
        find(0, 0, arr, result);
        return result;
    }

    private void find(int i, int sum, int[] arr, List<Integer> result) {
        if (i == arr.length) {
            result.add(sum);
            return;
        }

        // dont pick
        find(i+1, sum, arr, result);
        // pick
        find(i+1, sum + arr[i], arr, result);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3};
        SubsetSumI solution = new SubsetSumI();
        List<Integer> result = solution.find(arr);
        System.out.println(result);
    }
}
