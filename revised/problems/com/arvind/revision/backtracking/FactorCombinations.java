package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        getFactorsInner(2, n, new ArrayList<>(), res);
        return res;
    }

    private void getFactorsInner(int start, int number, List<Integer> factors, List<List<Integer>> res) {
        if (number == 1 && factors.size() > 1) {
            res.add(new ArrayList<>(factors));
            return;
        }

        int upperLimit = (int) Math.sqrt(number) + 1;

        for (int i=start; i< upperLimit; i++) {
            // check if factor
            if (number % i == 0) {
                factors.add(i);
                int otherFactor = number / i;
                if (otherFactor >= i) {
                    factors.add(otherFactor);
                    getFactorsInner(i, 1, factors, res);
                    factors.remove(factors.size() - 1);
                }
                getFactorsInner(i, otherFactor, factors, res);
                factors.remove(factors.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 12;
        FactorCombinations solution = new FactorCombinations();
        CommonUtils.printListListInt(solution.getFactors(n));
    }
}
