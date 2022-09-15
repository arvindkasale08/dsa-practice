package arvind;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParanthesis(int n) {
        List<String> results = new ArrayList<>();
        generateParanthesis(n, 0, 0, "", results);
        return results;
    }

    public void generateParanthesis(int n, int open, int closed, String result, List<String> results) {
        if (open == closed && closed == n) {
            results.add(result);
        }
        if (closed > open || closed > n || open > n) {
            return;
        }

        generateParanthesis(n, open + 1, closed, result + "(", results);
        generateParanthesis(n, open, closed + 1, result + ")", results);
    }

    public static void main(String[] args) {
        GenerateParanthesis solution = new GenerateParanthesis();
        int n = 3;
        List<String> result = solution.generateParanthesis(n);
        System.out.println(result);
    }
}
