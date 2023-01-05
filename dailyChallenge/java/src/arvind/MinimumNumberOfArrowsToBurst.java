package arvind;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurst {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int arrowsNeeded = 1;
        int l = points[0][0];
        int h = points[0][1];
        int n = points.length;

        for (int i=1; i<n; i++) {
            int[] nextPt = points[i];
            if (nextPt[0] > h) {
                arrowsNeeded++;
                l = nextPt[0];
                h = nextPt[1];
            } else {
                l = Math.max(l, nextPt[0]);
                h = Math.min(h, nextPt[1]);
            }
        }

        return arrowsNeeded;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {{1,2},{2,3},{4,5},{5,6}};
        MinimumNumberOfArrowsToBurst solution = new MinimumNumberOfArrowsToBurst();
        int result = solution.findMinArrowShots(points);
        System.out.println(result);
    }
}
