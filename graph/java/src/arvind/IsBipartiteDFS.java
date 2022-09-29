package arvind;

public class IsBipartiteDFS {

    public boolean check(int[][] graph) {
        int size = graph.length;
        int[] visited = new int[size];
        for (int i=0; i<size; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if (!dfs(graph, i, visited, 1)) return false;
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int vertex, int[] visited, int color) {
        if (visited[vertex] != 0 && visited[vertex] != color) {
            return false;
        }
        visited[vertex] = color;
        int nextColor = color == 1 ? -1 : 1;
        for (Integer neighbor : graph[vertex]) {
            if (visited[neighbor] == 0) {
                if (!dfs(graph, neighbor, visited, nextColor)) return false;
            } else if (visited[neighbor] != nextColor){
                 return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {{1, 2, 3}, {0,2}, {0, 1, 3}, {0, 2}}; // false
        //int[][] graph = new int[][] {{1, 3}, {0,2}, {1, 3}, {0, 2}}; // true
        IsBipartiteDFS dfs = new IsBipartiteDFS();
        boolean isBipartite = dfs.check(graph);
        System.out.println(isBipartite);
    }
}
