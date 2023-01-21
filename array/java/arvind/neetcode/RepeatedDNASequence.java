package arvind.neetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> bank = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for (int i=0; i<s.length()-9; i++) {
            String newStr = s.substring(i, i+10);
            if (bank.contains(newStr)) {
                res.add(newStr);
                continue;
            }
            bank.add(newStr);
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        RepeatedDNASequence solution = new RepeatedDNASequence();
        List<String> result = solution.findRepeatedDnaSequences(s);
        System.out.println(result);
    }
}
