import java.io.*;
import java.util.*;
import java.util.LinkedList;
class GraphNode
{
    private int V;
    private LinkedList<Integer> adj[];
    GraphNode(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v,int w) { adj[v].add(w); }
    void DFSUtil(int v,Boolean visited[])
    {
        visited[v] = true;
        int n;
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }
    GraphNode getTranspose()
    {
        GraphNode g = new GraphNode(V);
        for (int v = 0; v < V; v++) {
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    Boolean isSC() {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        DFSUtil(0, visited);
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                return false;
        GraphNode gr = getTranspose();
        for (int i = 0; i < V; i++)
            visited[i] = false;
        gr.DFSUtil(0, visited);
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                return false;

        return true;
    }

    public static void main(String args[]) {
        GraphNode g1 = new GraphNode(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        if (g1.isSC())
            System.out.println("Yes");
        else
            System.out.println("No");

        GraphNode g2 = new GraphNode(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        if (g2.isSC())
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}


