package ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphBFSImpl {
    private int size;
    public Object[] vertexList;

    public GraphBFSImpl(int size) {
        this.size = size;
        vertexList = new Object[size];
    }

    public void addEdge(int src, int dest) {
        if (vertexList[src] != null) {
            ArrayList<Integer> edgeList =
                    (ArrayList<Integer>) vertexList[src];
            if (edgeList.contains(dest))
                return;
            edgeList.add(dest);
            vertexList[src] = edgeList;
        } else {
            ArrayList<Integer> edgeList = new ArrayList<>();
            edgeList.add(dest);
            vertexList[src] = edgeList;
        }
    }
    public void bfs(int startNode) {
        boolean visited[] = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.print(element);
            if (vertexList[element] != null) {
                ArrayList<Integer> connectedNodes =
                        (ArrayList<Integer>) vertexList[element];
                for (int node : connectedNodes) {
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        for (int j = 0; j < numTestCases; j++) {
            int n = in.nextInt();
            GraphBFSImpl graph =
                    new GraphBFSImpl(n);
            int firstElement = -1;
            for (int i = 0; i < n; i++) {
                int source = in.nextInt();
                int dest = in.nextInt();
                if (firstElement < 0)
                    firstElement = source;
                graph.addEdge(source, dest);
            }
            graph.bfs(firstElement);
        }
    }

}
