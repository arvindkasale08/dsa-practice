package arvind;

import java.util.Stack;

public class CelebrityProblem {

    public int solveInPlace(int[][] arr) {
        int i=0;
        int n = arr.length;
        int j = n - 1;

        while (i < j) {
            if (arr[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }

        for (int k=0; k< n; k++) {
            if (i != k && ( arr[i][k] == 1 || arr[k][i] == 0 )) {
                return -1;
            }
        }

        return i;
    }

    public int solveWithStack(int[][] arr) {
        Stack<Integer> celebrityStack = new Stack<>();
        for (int i=0; i < arr.length; i++) {
            celebrityStack.push(i);
        }

        while (celebrityStack.size() > 1) {
            int i = celebrityStack.pop();
            int j = celebrityStack.pop();

            if (arr[i][j] == 1) {
                // i not celebrity j could be celebrity
                celebrityStack.push(j);
            } else {
                // i doenst know j j is not a celebrity
                celebrityStack.push(i);
            }
        }

        int potential = celebrityStack.pop();
        // verify if potential is the celebrity or not
        for (int k=0; k< arr.length; k++) {
            if (potential != k && (arr[potential][k] == 1 || arr[k][potential] == 0)) {
                return -1;
            }
        }
        return potential;
    }

    public static void main(String[] args) {
        CelebrityProblem problem = new CelebrityProblem();
        int[][] arr = new int[][] {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };

        // expected celebrity is B (1)
        int celebrity = problem.solveInPlace(arr);
        System.out.println("Celebrity is "+ celebrity);
    }
}
