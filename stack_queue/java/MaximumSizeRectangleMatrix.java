import java.util.Arrays;
import java.util.Stack;

public class MaximumSizeRectangleMatrix {
    static int getMaxArea(int hist[]) {
        int heights[] = Arrays.copyOf(hist, hist.length + 1);
        heights[hist.length] = 0;
        Stack<Integer> pstack = new Stack();
        Stack<Integer> hstack = new Stack();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int last_width = heights.length + 1;
            while (!pstack.isEmpty() && heights[i] < hstack.peek()) {
                last_width = pstack.peek();
                maxArea = Math.max(maxArea, (i - pstack.pop()) * hstack.pop());
            }
            if (pstack.isEmpty() || hstack.peek() <= heights[i]) {
                pstack.push(Math.min(i, last_width));
                hstack.push(heights[i]);
            }


        }
        return maxArea;
    }

    static int maxRec(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = getMaxArea(matrix[0]);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                }
            }
            maxArea = Math.max(maxArea, getMaxArea(matrix[i]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int A[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.print("Area of maximum rectangle is " + maxRec(A));
    }
}

