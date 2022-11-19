package arvind.p1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    public List<List<Integer>> findCombinations(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, 0, new ArrayList<>(), candidates, target, result);
        return result;
    }

    private void findCombinations(int idx, int sum, List<Integer> list, int[] candidates, int target, List<List<Integer>> result) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=idx; i<candidates.length; i++) {
            list.add(candidates[i]);
            findCombinations(i, sum + candidates[i], list, candidates, target, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumI solution = new CombinationSumI();
        int[] candidates = {1, 2, 3};
        int target = 4;
        List<List<Integer>> result = solution.findCombinations(candidates, target);
        System.out.println(result);
    }
}
