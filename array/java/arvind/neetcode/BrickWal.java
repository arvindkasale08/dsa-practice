package arvind.neetcode;

import java.util.HashMap;

public class BrickWal {

    public int leastBricks(int[][] wall) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i=0; i<wall.length; i++) {
            int k = 0;
            for (int j=0; j < wall[i].length-1; j++) {
                k = k + wall[i][j];
                hash.put(k, hash.getOrDefault(k, 0)+1);
            }
        }
        if (hash.isEmpty()) {
            return wall.length;
        }
        return wall.length - hash.values().stream().max(Integer::compareTo).get() ;
    }

    public static void main(String[] args) {
        BrickWal solution = new BrickWal();
        int[][] wall = new int[][] {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        //int[][] wall = new int[][] {{1}, {1}, {1}};
        int cutBricks = solution.leastBricks(wall);
        System.out.println(cutBricks);
    }
}
