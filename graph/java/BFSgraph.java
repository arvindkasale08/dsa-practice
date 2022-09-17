import java.util.*;
public class BFSgraph {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans= new ArrayList<>();
        Queue <Integer> que=new LinkedList<Integer>();
        que.add(0);
        boolean [] visited=new boolean[V+1];
        visited[0]=true;
        while(que.isEmpty()==false){
            int u=que.poll();
            ans.add(u);
            for(int v:adj.get(u)){
                if(visited[v]==false){
                    visited[v]=true;
                    que.add(v);
                }

            }
        }
        return ans;
    }
    static void printAns(ArrayList < Integer > ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

        // adding new arraylists to 'adj' to add neighbour nodes
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);



        ArrayList < Integer > ans = bfsOfGraph(5, adj);
        printAns(ans);
    }
}


