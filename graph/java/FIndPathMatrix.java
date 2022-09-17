import java.io.*;
import java.util.*;

class graphpair {
    int Item1, Item2;
    graphpair(int f, int s)
    {
        Item1 = f;
        Item2 = s;
    }
}

class PathMain {



    // To find the path from
    // top left to bottom right
    static boolean isPath(int[][] arr, int row, int col)
    {

        // Directions
        int[][] dir
                = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // Queue
        Queue<graphpair> q = new LinkedList<>();

        // Insert the top right corner.
        q.add(new graphpair(0, 0));

        // Until queue is empty
        while (q.size() > 0) {
            graphpair p = (q.peek());
            q.remove();

            // Mark as visited
            arr[p.Item1][p.Item2] = -1;

            // Destination is reached.
            if (p.Item1 == row - 1 && p.Item2 == col - 1)
                return true;

            // Check all four directions
            for (int i = 0; i < 4; i++) {

                // Using the direction array
                int a = p.Item1 + dir[i][0];
                int b = p.Item2 + dir[i][1];

                // Not blocked and valid
                if (a >= 0 && b >= 0 && a < row && b < col
                        && arr[a][b] != -1) {
                    if (a == row - 1 && b == col - 1)
                        return true;

                    q.add(new graphpair(a, b));
                }
            }
        }
        return false;
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given array
        int[][] arr = {{ 0, 0, 0, -1, 0},
                {-1, 0, 0, -1, -1},
                { 0, 0, 0, -1, 0},
                {-1, 0, -1, 0, 0},
                { 0, 0, -1, 0, 0}};
        int row = arr.length;
        int col = arr[0].length;
        // Path from arr[0][0] to arr[row][col]
        if (isPath(arr, row, col))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

//public class FIndPathMatrix {

