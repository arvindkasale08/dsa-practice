package arvind.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis2 {

    public List<String> findParanthesis(int n) {
        List<String> results = new ArrayList<>();
        findParanthesis(n, "", 0, 0, results);
        return results;
    }

    public void findParanthesis(int n, String s, int open, int closed, List<String> result) {
        if (open == closed && open == n) {
            result.add(s);
            return;
        }
        if (closed > open || open > n || closed > n) {
            return;
        }
        findParanthesis(n, s + "(", open + 1, closed, result);
        findParanthesis(n, s + ")", open, closed + 1, result);
    }

    public static void main(String[] args) {
        GenerateParanthesis2 solution = new GenerateParanthesis2();
        int n = 3;
        List<String> result = solution.findParanthesis(n);
        System.out.println(result);
    }
}
