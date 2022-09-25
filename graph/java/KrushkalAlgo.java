import java.util.*;

class KrushkalNode
{
    private int u;
    private int v;
    private int weight;

    KrushkalNode(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }

    KrushkalNode() {}

    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}

class SortComparator implements Comparator<KrushkalNode> {
    @Override
    public int compare(KrushkalNode KrushkalNode1, KrushkalNode KrushkalNode2)
    {
        if (KrushkalNode1.getWeight() < KrushkalNode2.getWeight())
            return -1;
        if (KrushkalNode1.getWeight() > KrushkalNode2.getWeight())
            return 1;
        return 0;


    }
}

class KrushkalMain
{
    private int findPar(int u, int parent[]) {
        if(u==parent[u]) return u;
        return parent[u] = findPar(parent[u], parent);
    }
    private void union(int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);
        if(rank[u] < rank[v]) {
            parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
            parent[v] = u;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
    void KruskalAlgo(ArrayList<KrushkalNode> adj, int N)
    {
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N];
        int rank[] = new int[N];

        for(int i = 0;i<N;i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMst = 0;
        ArrayList<KrushkalNode> mst = new ArrayList<KrushkalNode>();
        for(KrushkalNode it: adj) {
            if(findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
                costMst += it.getWeight();
                mst.add(it);
                union(it.getU(), it.getV(), parent, rank);
            }
        }
        System.out.println(costMst);
        for(KrushkalNode it: mst) {
            System.out.println(it.getU() + " - " +it.getV());
        }
    }
    public static void main(String args[])
    {
        int n = 5;
        ArrayList<KrushkalNode> adj = new ArrayList<KrushkalNode>();


        adj.add(new KrushkalNode(0, 1, 2));
        adj.add(new KrushkalNode(0, 3, 6));
        adj.add(new KrushkalNode(1, 3, 8));
        adj.add(new KrushkalNode(1, 2, 3));
        adj.add(new KrushkalNode(1, 4, 5));
        adj.add(new KrushkalNode(2, 4, 7));


        KrushkalMain obj = new KrushkalMain();
        obj.KruskalAlgo(adj, n);

    }
}