package arvind.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generate(int n) {
        List<String> results = new ArrayList<>();
        generate(0, 0, n, "", results);
        return results;
    }

    public void generate(int open, int closed, int n, String str, List<String> results) {
        if (open == closed && open == n) {
            results.add(str);
        }
        if (open > n || closed > n || closed > open) {
            return;
        }
        generate(open + 1, closed, n, str + "(", results);
        generate(open, closed + 1, n, str + ")", results);
    }

    public static void main(String[] args) {
        GenerateParanthesis solution = new GenerateParanthesis();
        int n = 2;
        List<String> result = solution.generate(n);
        System.out.println(result);
    }
}
