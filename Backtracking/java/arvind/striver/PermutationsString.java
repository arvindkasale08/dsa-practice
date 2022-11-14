package arvind.striver;

import arvind.PermutationString;

import java.util.ArrayList;
import java.util.List;

public class PermutationsString {

    public List<String> permute(String str) {
        char[] ch = str.toCharArray();
        List<String> result = new ArrayList<>();
        permute(ch, 0, result);
        return result;
    }

    private void permute(char[] ch, int ind, List<String> result) {
        if (ind == ch.length)
            result.add(new String(ch));

        for (int j=ind; j<ch.length; j++) {
            swap(ch, ind, j);
            permute(ch, ind+1, result);
            swap(ch, ind, j);
        }
    }

    private void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public static void main(String[] args) {
        PermutationString solution = new PermutationString();
        String str = "ABC";
        List<String> result = solution.permute(str);
        System.out.println(result);
    }
}
