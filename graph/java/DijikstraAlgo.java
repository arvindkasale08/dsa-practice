import java.util.*;

class GNode implements Comparator<GNode>
{
    private int v;
    private int weight;

    GNode(int _v, int _w) { v = _v; weight = _w; }

    GNode() {}

    int getV() { return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(GNode node1, GNode node2)
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}

class DijiMain
{
    void shortestPath(int s, ArrayList<ArrayList<GNode>> adj, int N)
    {
        int dist[] = new int[N];

        for(int i = 0;i<N;i++) dist[i] = 100000000;
        dist[s] = 0;

        PriorityQueue<GNode> pq = new PriorityQueue<GNode>(N, new GNode());
        pq.add(new GNode(s, 0));

        while(pq.size() > 0) {
            GNode node = pq.poll();

            for(GNode it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new GNode(it.getV(), dist[it.getV()]));
                }
            }
        }
        System.out.println("The distances from source "+s+" are : ");
        for (int i = 0; i < N; i++)
        {
            System.out.print( dist[i] + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<ArrayList<GNode> > adj = new ArrayList<ArrayList<GNode> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<GNode>());

        adj.get(0).add(new GNode(1, 2));
        adj.get(1).add(new GNode(0, 2));

        adj.get(1).add(new GNode(2, 4));
        adj.get(2).add(new GNode(1, 4));

        adj.get(0).add(new GNode(3, 1));
        adj.get(3).add(new GNode(0, 1));

        adj.get(3).add(new GNode(2, 3));
        adj.get(2).add(new GNode(3, 3));

        adj.get(1).add(new GNode(4, 5));
        adj.get(4).add(new GNode(1, 5));

        adj.get(2).add(new GNode(4, 1));
        adj.get(4).add(new GNode(2, 1));

        DijiMain obj = new DijiMain();
        obj.shortestPath(0, adj, n);

    }
}