package arvind.striver;

public class GraphValidTree {

    class DisjointSet {
        private int[] parent;
        private int[] size;
        private int V;

        public DisjointSet(int V) {
            this.V = V;
            this.size = new int[V];
            this.parent = new int[V];
            for (int i=0; i< V; i++) {
                this.size[i] = 1;
                this.parent[i] = i;
            }
        }

        public int findParent(int u) {
            if (u == parent[u])
                return u;
            return parent[u] = findParent(parent[u]);
        }

        private void union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }

        // single parent
        public boolean isSingleRoot() {
            int count = 0;
            for (int i=0; i< parent.length; i++) {
                if (i == parent[i])
                    count++;
            }
            return count == 1 ? true : false;
        }
    }

    public boolean isValidTree(int[][] edges, int V) {
        DisjointSet set = new DisjointSet(V);
        for (int[] edge : edges) {
            int pu = set.findParent(edge[0]);
            int pv = set.findParent(edge[1]);
            if (pu == pv)
                return false;
            set.union(edge[0], edge[1]);
        }
        return set.isSingleRoot();
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1}, {2,3}};
        int V = 4;
        GraphValidTree solution = new GraphValidTree();
        boolean isValid = solution.isValidTree(edges, V);
        System.out.println(isValid);
    }
}
