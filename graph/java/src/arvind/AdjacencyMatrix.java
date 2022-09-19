package arvind;

public class AdjacencyMatrix {

	private int size;
	private int[][] graph;

	public AdjacencyMatrix(int size) {
		this.size = size;
		this.graph = new int[size][size];
	}

	public void addEdge(int src, int dest) {
		this.graph[src][dest] = 1;
		// if undirected then set below as well
		this.graph[dest][src] = 1;
	}

	public void printGraph() {
		for (int i=0; i < size; i++) {
			for (int j=0; j<size; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		AdjacencyMatrix matrix = new AdjacencyMatrix(5);
		matrix.addEdge(0, 1);
		matrix.addEdge(0, 2);
		matrix.addEdge(0, 3);
		matrix.addEdge(2, 3);
		matrix.addEdge(2, 1);
		matrix.addEdge(2, 4);
		matrix.addEdge(1, 4);
		matrix.addEdge(3, 4);

		matrix.printGraph();
	}
}
