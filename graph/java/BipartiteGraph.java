import java.util.Arrays;
import java.util.LinkedList;

public class BipartiteGraph {
    public static boolean isBipartiteUtil(int G[][], int src, int colorArr[], int V)
    {
        colorArr[src] = 1;
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);
        while (!q.isEmpty()) {
            int u = q.getFirst();
            q.pop();
            if (G[u][u] == 1)
                return false;
            for (int v = 0; v < V; ++v) {
                if (G[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }
                else if (G[u][v] == 1 && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        return true;
    }
    public static boolean isBipartite(int G[][], int V) {
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;
        for (int i = 0; i < V; i++)
            if (colorArr[i] == -1)
                if (!isBipartiteUtil(G, i, colorArr, V))
                    return false;

        return true;
    }
    public static void main(String[] args) {
        int G[][] = {{1, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};
        int V = G.length;
        if (isBipartite(G, V)){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }
}
