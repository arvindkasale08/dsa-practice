package arvind.neetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> find(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> res = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (i==0 || j==0 || j==i) {
                    res.add(1);
                } else {
                    res.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        PascalsTriangle solution = new PascalsTriangle();
        List<List<Integer>> result = solution.find(numRows);
        System.out.println(result);
    }
}
