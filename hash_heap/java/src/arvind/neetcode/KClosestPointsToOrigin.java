package arvind.neetcode;

import java.sql.SQLOutput;
import java.util.*;

public class KClosestPointsToOrigin {

    class Point {
        int[] coodinate;

        public Point(int[] coodinate) {
            this.coodinate = coodinate;
        }

        double getDistance() {
            return Math.sqrt(((this.coodinate[0] - 0) * (this.coodinate[0] - 0))  + ((this.coodinate[1] -0) * (this.coodinate[1] -0)));
        }
    }

    public int[][] kClosest(int[][] arr, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(Point::getDistance));
        for (int[] coordinate : arr) {
            Point p = new Point(coordinate);
            queue.offer(p);
        }
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < k) {
            Point p = queue.poll();
            result.add(p.coodinate);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{3,3},{5,-1},{-2,4}};
        int k = 2;
        KClosestPointsToOrigin solution = new KClosestPointsToOrigin();
        int[][] result = solution.kClosest(arr, k);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}
