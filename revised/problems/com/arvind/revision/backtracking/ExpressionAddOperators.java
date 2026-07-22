package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        addOperatorsInner(0, num, target, 0, Integer.MIN_VALUE, "", res);
        return res;
    }

    private void addOperatorsInner(int idx, String num, int target, long sum, long last, String path, List<String> res) {
        if (idx == num.length() && sum == target) {
            res.add(path);
            return;
        }


        for (int i=idx; i<num.length(); i++) {
            String numFormed = num.substring(idx, i+1);
            long numFormedInt = Long.parseLong(numFormed);

            if (i > idx && num.charAt(idx) == '0') return;

            if (last == Integer.MIN_VALUE) {
                addOperatorsInner(i+1, num, target, sum + numFormedInt, numFormedInt, path + numFormed, res);
            } else {
                // need to do 3 things
                addOperatorsInner(i + 1, num, target, sum + numFormedInt, numFormedInt, path + "+" + numFormed, res); // sum
                addOperatorsInner(i + 1, num, target, sum - numFormedInt, -numFormedInt, path + "-" + numFormed, res); // diff
                addOperatorsInner(i + 1, num, target, "".equals(path) ? numFormedInt : (sum - last) + (numFormedInt * last), (numFormedInt * last), path + "*" + numFormed, res); // mul
            }
        }

    }

    public static void main(String[] args) {
        String num = "3456237490";
        int target = 9191;
        ExpressionAddOperators solution = new ExpressionAddOperators();
        CommonUtils.printListStr(solution.addOperators(num, target));
    }
}
