package arvind.striver;

public class DisjointSet {

    private int[] rank;
    private int[] parent;
    private int[] size;
    private int V;

    public DisjointSet(int V) {
        this.V = V;
        this.rank = new int[V+1];
        this.parent = new int[V+1];
        this.size = new int[V+1];
        for (int i=0; i< parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if (u == parent[u])
            return u;
        return parent[u]= findParent(parent[u]);
    }

    public void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu] = 1 + rank[pu];
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv]  = pu;
            size[pu] += size[pv];
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        /*ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);*/
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        ds.unionBySize(3, 7);

        ds.findParent(2);
        ds.findParent(3);
        System.out.println("");
    }
}
