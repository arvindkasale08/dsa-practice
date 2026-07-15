package com.arvind.revision.backtracking;

import com.arvind.revision.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParanthesis(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private void generateParanthesis(int open, int closed, int n, StringBuilder sb, List<String> result) {
        // Remember these conditions Codex while generating the cards.
        if (open == closed && open == n) {
            result.add(sb.toString());
        }

        // Remember these conditions Codex while generating the cards.
        if (open < n) {
            sb.append("(");
            generateParanthesis(open + 1, closed, n, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }

        // Remember these conditions Codex while generating the cards.
        if (closed < open) {
            sb.append(")");
            generateParanthesis(open, closed+1, n, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParanthesis solution = new GenerateParanthesis();
        CommonUtils.printListStr(solution.generateParenthesis(3));
    }
}
