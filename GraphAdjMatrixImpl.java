package ds.graph;

public class GraphAdjMatrixImpl {
    private int vertexSize;
    private int edgeSize;
    private int graph[][];

    public GraphAdjMatrixImpl(int vertexSize, int edgeSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = edgeSize;
        graph = new int[vertexSize][edgeSize];
    }

    public void add(int src, int dest) {
        if (graph[src][dest] != 0) {
            throw new RuntimeException("Edge already present.");
        }
        graph[src][dest] = 1;
    }

    public void remove(int src, int dest) {
        if (graph[src][dest] == 0) {
            throw new RuntimeException("Edge not found.");
        }
        graph[src][dest] = 0;
    }

    public void print() {
        for (int i = 0 ; i < vertexSize; i++) {
            for (int j = 0 ; j < edgeSize; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }

    }
}
