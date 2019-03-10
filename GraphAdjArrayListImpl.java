
package ds.graph;

import java.util.*;

/**
 * This is the implementation of the undirected graph adjacency list using hashmap.
 * @author dinesh
 * @version 1.0
 */
public class GraphAdjArrayListImpl {
    private int numVertex;
    private int numEdges;
    private Map<Object, ArrayList<Object>> vertexMap;

    public GraphAdjArrayListImpl(int vertexNumber, int edgeNumber) {
        this.numVertex = vertexNumber;
        this.numEdges = edgeNumber;
        vertexMap = new HashMap<Object, ArrayList<Object>>(numVertex);
        for (int i = 0 ; i < numVertex; i++) {
            ArrayList<Object> emptyList = new ArrayList<>();
            vertexMap.put(i, emptyList);
        }
    }

    /**
     * Adds the edge between source and destination.
     * worst case Complexity O(n) but 0(log n) in Java 8 as it uses balanced tree.
     * @param src
     * @param dest
     */
    public void addEdge(Object src, Object dest) {

        if ((!vertexMap.containsKey(src) || !vertexMap.containsKey(dest))
                && vertexMap.size() >= numVertex) {
            throw new RuntimeException("Graph size exceeded");
        }
        if (vertexMap.containsKey(src)) {
            updateEdgeList(src, dest);
        } else {
            addNewEdgeList(src, dest);
        }
        if (vertexMap.containsKey(dest)) {
            updateEdgeList(dest, src);
        } else {
            addNewEdgeList(dest, src);
        }
    }

    private void addNewEdgeList(Object firstNode, Object secondNode) {
        ArrayList<Object> newEdgeList = new ArrayList<>(numEdges);
        newEdgeList.add(secondNode);
        vertexMap.put(firstNode, newEdgeList);
    }

    private void updateEdgeList(Object firstNode, Object secondNode) {
        ArrayList<Object> edgeList = vertexMap.get(firstNode);
        if (edgeList.size() == numEdges) {
            throw new RuntimeException("Edge size exceeded");
        } else if (edgeList.contains(secondNode)) {
            return;
        }
        edgeList.add(secondNode);
        vertexMap.put(firstNode, edgeList);
    }


    public void removeEdge(Object src, Object dest) {
        if (!vertexMap.containsKey(src)) {
            throw new RuntimeException("No edge found");
        }
        ArrayList<Object> edgeList = vertexMap.get(src);
        edgeList.remove(dest);
        vertexMap.put(src, edgeList);
    }

    public int getSize() {
        return vertexMap.size();
    }

    public void print() {
        for(Map.Entry<Object, ArrayList<Object>> entry : vertexMap.entrySet()) {
            ArrayList<Object> edgeList = entry.getValue();
            System.out.print(entry.getKey());
            for (Object edge : edgeList) {
                System.out.print("-> ");
                System.out.print(edge);
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();
        for (int j = 0; j < numTestCases; j++) {
            int numVertex = in.nextInt();
            int numEdges = in.nextInt();
            GraphAdjArrayListImpl graph =
                    new GraphAdjArrayListImpl(numVertex, numEdges);
            for (int i = 0; i < numEdges; i++) {
                int source = in.nextInt();
                int dest = in.nextInt();
                graph.addEdge(source, dest);
            }
            graph.print();
        }
    }


}
