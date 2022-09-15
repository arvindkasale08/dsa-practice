package arvind;

import arvind.practice.Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

    public List<String> permute(String input) {
        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, input.length(), result);
        return result;
    }

    private void permute(char[] c, int start, int n, List<String> result) {
        if (start == n) {
            result.add(new String(c));
        }
        for (int i = start; i<n; i++) {
            swap(c, i, start);
            permute(c, start + 1, n, result);
            swap(c, i, start);
        }
    }

    private void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public static void main(String[] args) {
        PermutationString solution = new PermutationString();
        String input = "ABC";
        List<String> result = solution.permute(input);
        System.out.println(result);
    }
}
