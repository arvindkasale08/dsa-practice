package arvind.striver;

public class NumberOfConnectedComponentsInUndirectedGraph {

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

        public int noOfComponents() {
            int count = 0;
            for (int i=0; i< parent.length; i++) {
                if (parent[i] == i)
                    count++;
            }
            return count;
        }
    }
    public int findNumberOfConnectedComponents(int V, int[][] edges) {
        DisjointSet set = new DisjointSet(V);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }
        return set.noOfComponents();
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInUndirectedGraph solution = new NumberOfConnectedComponentsInUndirectedGraph();
        int V = 5;
        int[][] edges = new int[][] {{0,1},{1,2},{3,4}};
        int components = solution.findNumberOfConnectedComponents(V, edges);
        System.out.println(components);
    }
}
