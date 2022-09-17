import java.util.*;
public class DFSgraph {
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0;i<V;i++) {
            if(!visited.contains(i)) dfs(i, adj, res, visited);
        }
        return res;
    }
    private static void dfs(int V, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> store, Set<Integer> visited){
        store.add(V);
        visited.add(V);

        for(var neighbor : adj.get(V)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, adj, store, visited);
            }
        }
    }
    static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        ArrayList < Integer > ans = dfsOfGraph(5, adj);
        printAns(ans);
    }
}
