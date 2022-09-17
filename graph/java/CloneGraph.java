import java.util.*;
class CloneNode
{
    int val;
    Vector<CloneNode> neighbours;
    public CloneNode(int val)
    {
        this.val = val;
        neighbours = new Vector<CloneNode>();
    }
}

class Driver
{
    public CloneNode cloneGraph(CloneNode source)
    {
        Queue<CloneNode> q = new LinkedList<CloneNode>();
        q.add(source);
        HashMap<CloneNode,CloneNode> hm = new HashMap<CloneNode,CloneNode>();
        hm.put(source,new CloneNode(source.val));

        while (!q.isEmpty()) {
            CloneNode u = q.poll();
            CloneNode cloneNodeU = hm.get(u);
            if (u.neighbours != null)
            {
                Vector<CloneNode> v = u.neighbours;
                for (CloneNode CloneNode : v) {
                    CloneNode cloneNodeG = hm.get(CloneNode);
                    if (cloneNodeG == null)
                    {
                        q.add(CloneNode);
                        cloneNodeG = new CloneNode(CloneNode.val);
                        hm.put(CloneNode,cloneNodeG);
                    }
                    cloneNodeU.neighbours.add(cloneNodeG);
                }
            }
        }
        return hm.get(source);
    }

    public CloneNode buildGraph() {
        CloneNode node1 = new CloneNode(1);
        CloneNode node2 = new CloneNode(2);
        CloneNode node3 = new CloneNode(3);
        CloneNode node4 = new CloneNode(4);
        Vector<CloneNode> v = new Vector<CloneNode>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new Vector<CloneNode>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new Vector<CloneNode>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new Vector<CloneNode>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }

    public void bfs(CloneNode source)
    {
        Queue<CloneNode> q = new LinkedList<CloneNode>();
        q.add(source);
        HashMap<CloneNode,Boolean> visit = new HashMap<CloneNode,Boolean>();
        visit.put(source,true);
        while (!q.isEmpty())
        {
            CloneNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null)
            {
                Vector<CloneNode> v = u.neighbours;
                for (CloneNode g : v)
                {
                    if (visit.get(g) == null)
                    {
                        q.add(g);
                        visit.put(g,true);
                    }
                }
            }
        }
        System.out.println();
    }
}

class Main
{
    public static void main(String args[])
    {
        Driver graph = new Driver();
        CloneNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        graph.bfs(source);
        CloneNode newSource = graph.cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        graph.bfs(newSource);
    }
}
