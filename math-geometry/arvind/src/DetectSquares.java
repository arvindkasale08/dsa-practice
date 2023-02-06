import java.util.*;
import java.util.stream.Collectors;

class DetectSquares {

    private Map<String, Integer> pointCount;
    private Set<String> points;
    public DetectSquares() {
        pointCount = new HashMap<>();
        points = new HashSet<>();
    }

    public void add(int[] point) {
        points.add(convert(point));
        pointCount.put(convert(point), pointCount.getOrDefault(convert(point), 0) + 1);
    }

    public int count(int[] pt1) {
        int count = 0;

        if (pointCount.containsKey(convert(pt1))) {
            return 0;
        }

        for (String str : points) {
            int[] pt2 = convertBack(str);
            // same point
            if (pt2[0] == pt1[0] && pt2[1] == pt1[1]) {
                continue;
            }
            // check if point diagonal
            if (isDiagonal(pt1, pt2)) {
                // found valid diagonal point;
                // check if other points are present;
                int[] pt3 = new int[]{pt1[0], pt2[1]};
                int[] pt4 = new int[]{pt2[0], pt1[1]};
                if (pointCount.containsKey(convert(pt3)) && pointCount.containsKey(convert(pt4))) {
                    count += 1 * pointCount.get(convert(pt2)) * pointCount.get(convert(pt3)) * pointCount.get(convert(pt4));
                }
            }
        }

        return count;
    }

    private boolean isDiagonal(int[] pt1, int[] pt2) {
        return Math.abs(pt1[0] - pt2[0]) == Math.abs(pt1[1] - pt2[1]);
    }

    private String convert(int[] point) {
        return point[0]+","+point[1];
    }

    private int[] convertBack(String point) {
        String[] pts = point.split(",");
        return new int[] {Integer.valueOf(pts[0]), Integer.valueOf(pts[1])};
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        System.out.println(detectSquares.count(new int[] {11, 10})); // return 1. You can choose:
        //   - The first, second, and third points
        System.out.println(detectSquares.count(new int[] {14, 8}));  // return 0. The query point cannot form a square with any points in the data structure.
        detectSquares.add(new int[] {11, 2});    // Adding duplicate points is allowed.
        System.out.println(detectSquares.count(new int[] {11, 10})); // return 2. You can choose://   - The first, second, and third points//   - The first, third, and fourth points
    }
}
