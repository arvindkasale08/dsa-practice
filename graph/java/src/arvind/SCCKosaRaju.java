package arvind;

import java.util.ArrayList;
import java.util.List;

public class SCCKosaRaju {

    private int size;
    private List<List<Integer>> graph;

    public SCCKosaRaju(int size) {
        this.size = size;
        this.graph = new ArrayList<>();
        for (int i=0; i<size; i++) {
            this.graph.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        // creating a directed edge
        this.graph.get(src).add(dest);
    }

    public List<List<Integer>> findScc(int size, List<List<Integer>> graph) {
        // toposort karo dfs se using stack...


        // find transpose

        // do rev dfs using stack elements as input (pop stack)

    }

    public static void main(String[] args) {
        SCCKosaRaju solution = new SCCKosaRaju(5);
        solution.addEdge(0, 1);
        solution.addEdge(1, 2);
        solution.addEdge(2, 0);
        solution.addEdge(1, 3);
        solution.addEdge(3, 4);

        System.out.println(solution.graph);
        List<List<Integer>> result = solution.findScc(solution.size, solution.graph);
        System.out.println(result);
    }
}
