package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public List<List<Integer>> find(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        find(0, n, k, new ArrayList<Integer>(), results);
        return results;
    }

    private void find(int idx, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (k == list.size())
            result.add(new ArrayList<>(list));
        for (int i=idx + 1; i <= n; i++) {
            list.add(i);
            find(i, n, k, list, result);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combination solution = new Combination();
        List<List<Integer>> result = solution.find(n, k);
        System.out.println(result);
    }
}
