package arvind.neetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberofPairsOfInterchangeableRectangles {

    public int interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> hash = new HashMap<>();
        int count = 0;
        for (int i=0; i<rectangles.length; i++) {
            int[] rect = rectangles[i];
            double ratio = (double) rect[1] / (double) rect[0];
            if (!hash.isEmpty() && hash.containsKey(ratio)) {
                count += hash.get(ratio);
            }
            hash.put(ratio, hash.getOrDefault(ratio, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{4,8},{3,6},{10,20},{15,30}};
        NumberofPairsOfInterchangeableRectangles solution = new NumberofPairsOfInterchangeableRectangles();
        int count = solution.interchangeableRectangles(rectangles);
        System.out.println(count);
    }
}
