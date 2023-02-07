import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<m; i++) {
            List<Integer> res = new ArrayList<>();
            for (int j=0; j<n; j++) {
                res.add(j, 0);
            }
            result.add(res);
        }

        for(int i=0; i< total; i++) {
            int idx = (i + k) % total;
            int[] now = getCell(i, m, n);
            int[] next = getCell(idx, m, n);
            result.get(next[0]).set(next[1], grid[now[0]][now[1]]);
        }
        return result;
    }

    private int[] getCell(int i, int m, int n) {
        return new int[] {i/n, i%n};
    }

    public static void main(String[] args) {
        Shift2DGrid solution = new Shift2DGrid();
        int[][] grid = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        int k = 5;
        List<List<Integer>> result = solution.shiftGrid(grid, k);
        System.out.println(result);
    }
}
