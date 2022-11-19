package arvind.striver;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {

    public List<List<Integer>> printAllSubsequence(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        printAllSubsequence(0, arr, new ArrayList<>(), result);
        return result;
    }

    private void printAllSubsequence(int index, int[] arr, List<Integer> list, List<List<Integer>> result) {
        if (index >= arr.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[index]);
        printAllSubsequence(index+1, arr, list, result);
        list.remove(list.size()-1);
        printAllSubsequence(index+1, arr, list, result);
    }

    public static void main(String[] args) {
        PrintAllSubsequence solution = new PrintAllSubsequence();
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = solution.printAllSubsequence(arr);
        System.out.println(result);
    }
}
