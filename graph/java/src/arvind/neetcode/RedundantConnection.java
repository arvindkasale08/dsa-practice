package arvind.neetcode;

public class RedundantConnection {

    class DisjointSet {
        private int V;
        private int[] parent;
        private int[] size;

        public DisjointSet(int V) {
            this.V = V;
            this.parent = new int[V+1];
            this.size = new int[V+1];
            for (int i=0; i<V; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int u) {
            if (parent[u] == u) {
                return u;
            }
            return parent[u] = findParent(parent[u]);
        }

        public void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;
            if (size[pu] > size[pv]) {
                parent[pv] = pu;
                size[pu] += size[pv];
            } else {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }

    public int[] findConnection(int[][] edges) {
        DisjointSet set = new DisjointSet(edges.length);
        int[] redundant = new int[2];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = set.findParent(u);
            int pv = set.findParent(v);
            if (pu == pv) {
                redundant[0] = u;
                redundant[1] = v;
                return redundant;
            }
            set.union(u, v);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        RedundantConnection solution = new RedundantConnection();
        int[][] edges = new int[][] {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        int[] res = solution.findConnection(edges);
        System.out.println(res[0] + " " + res[1]);
    }
}
