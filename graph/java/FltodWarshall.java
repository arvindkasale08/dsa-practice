class FloydWarshall {
    final static int INF = 99999;
    static void floydWarshall(int[][] graph, int vertexCount) {
        int[][] D = new int[vertexCount][vertexCount];

        for (int i = 0; i < vertexCount; i++) {

            for (int j = 0; j < vertexCount; j++) {

                D[i][j] = graph[i][j];

            }

        }

        for (int k = 0; k < vertexCount; k++) {

            for (int i = 0; i < vertexCount; i++) {

                for (int j = 0; j < vertexCount; j++) {

                    if (D[i][k] + D[k][j] < D[i][j]) {

                        D[i][j] = D[i][k] + D[k][j];

                    }

                }

            }

        }
        printMatrix(D);

    }
    static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j] + " ");

            }

            System.out.println();

        }

    }



    public static void main(String[] args) {
        int graph[][] = { { 0, 3, INF, 7 }, { 8, 0, 2, INF }, { 5, INF, 0, INF }, { 2, INF, INF, 0 } };

        System.out.println("Printing the original graph");

        printMatrix(graph);

        System.out.println("\nPrinting the graph after applying Floyd's warshall algorithm");

        floydWarshall(graph, graph.length);

    }

}

