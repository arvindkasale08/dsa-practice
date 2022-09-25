import java.util.*;

class PrimNode implements Comparator < PrimNode > {
    private int v;
    private int weight;

    PrimNode(int _v, int _w) {
        v = _v;
        weight = _w;
    }
    PrimNode() {}

    int getV() {
        return v;
    }
    int getWeight() {
        return weight;
    }

    @Override
    public int compare(PrimNode PrimNode1, PrimNode PrimNode2) {
        if (PrimNode1.weight < PrimNode2.weight)
            return -1;
        if (PrimNode1.weight > PrimNode2.weight)
            return 1;
        return 0;
    }
}

class PrimMain {
    void primsAlgo(ArrayList < ArrayList < PrimNode >> adj, int N) {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }

        PriorityQueue < PrimNode > pq = new PriorityQueue < PrimNode > (N, new PrimNode());

        key[0] = 0;
        parent[0] = -1;
        pq.add(new PrimNode(key[0], 0));
        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true;

            for (PrimNode it: adj.get(u)) {
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new PrimNode(it.getV(), key[it.getV()]));
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
    public static void main(String args[]) {
        int n = 5;
        ArrayList < ArrayList < PrimNode > > adj = new ArrayList < ArrayList < PrimNode > > ();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList < PrimNode > ());

        adj.get(0).add(new PrimNode(1, 2));
        adj.get(1).add(new PrimNode(0, 2));

        adj.get(1).add(new PrimNode(2, 3));
        adj.get(2).add(new PrimNode(1, 3));

        adj.get(0).add(new PrimNode(3, 6));
        adj.get(3).add(new PrimNode(0, 6));

        adj.get(1).add(new PrimNode(3, 8));
        adj.get(3).add(new PrimNode(1, 8));

        adj.get(1).add(new PrimNode(4, 5));
        adj.get(4).add(new PrimNode(1, 5));

        adj.get(2).add(new PrimNode(4, 7));
        adj.get(4).add(new PrimNode(2, 7));

        PrimMain obj = new PrimMain();
        obj.primsAlgo(adj, n);

    }
}