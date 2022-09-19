import java.io.*;
import java.util.*;
class Demo {

    private static class Pair {
        int x, y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    private static int largestRegion(int M[][])
    {
        int m = M.length;
        int n = M[0].length;
        Queue<Pair> q = new LinkedList<>();
        int area = 0;
        int ans = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (M[i][j] == 1) {
                    ans = 0;
                    q.offer(new Pair(i, j));
                    M[i][j] = -1;
                    while (!q.isEmpty()) {
                        Pair t = q.poll();
                        ans++;
                        int x = t.x;
                        int y = t.y;
                        if (x + 1 < m) {
                            if (M[x + 1][y] == 1) {
                                q.offer(new Pair(x + 1, y));
                                M[x + 1][y] = -1;
                            }
                        }
                        if (x - 1 >= 0) {
                            if (M[x - 1][y] == 1) {
                                q.offer(new Pair(x - 1, y));
                                M[x - 1][y] = -1;
                            }
                        }
                        if (y + 1 < n) {
                            if (M[x][y + 1] == 1) {
                                q.offer(new Pair(x, y + 1));
                                M[x][y + 1] = -1;
                            }
                        }
                        if (y - 1 >= 0) {
                            if (M[x][y - 1] == 1) {
                                q.offer(new Pair(x, y - 1));
                                M[x][y - 1] = -1;
                            }
                        }
                        if (x + 1 < m && y + 1 < n) {
                            if (M[x + 1][y + 1] == 1) {
                                q.offer(
                                        new Pair(x + 1, y + 1));
                                M[x + 1][y + 1] = -1;
                            }
                        }
                        if (x - 1 >= 0 && y + 1 < n) {
                            if (M[x - 1][y + 1] == 1) {
                                q.offer(
                                        new Pair(x - 1, y + 1));
                                M[x - 1][y + 1] = -1;
                            }
                        }
                        if (x - 1 >= 0 && y - 1 >= 0) {
                            if (M[x - 1][y - 1] == 1) {
                                q.offer(
                                        new Pair(x - 1, y - 1));
                                M[x - 1][y - 1] = -1;
                            }
                        }
                        if (x + 1 < m && y - 1 >= 0) {
                            if (M[x + 1][y - 1] == 1) {
                                q.offer(
                                        new Pair(x + 1, y - 1));
                                M[x + 1][y - 1] = -1;
                            }
                        }
                    }

                    area = Math.max(area, ans);
                    ans = 0;
                }
            }
        }
        return area;
    }
    public static void main(String[] args)
    {
        int M[][] = { { 0, 0, 1, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 } };

        // Function call
        System.out.println(largestRegion(M));
    }
}
