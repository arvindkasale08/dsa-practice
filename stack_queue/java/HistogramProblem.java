import java.lang.reflect.Array;
import java.util.*;
public class Histogram {
    static int getMaxArea(int hist[], int n) {
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

    public static void main(String[] args) {
        int hei [] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Res: " + getMaxArea(hei, hei.length));
    }
}