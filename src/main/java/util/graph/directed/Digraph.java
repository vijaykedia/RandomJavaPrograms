package util.graph.directed;

import org.jetbrains.annotations.NotNull;
import util.Input;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vijaykedia on 02/11/15.
 * Graph implementation where direction of edges matters
 */
public class DiGraph {

    private final int vertices;
    private int edges;

    @NotNull private final List<Integer>[] adjacentVertices;
    @NotNull private final int[] inDegree;

    /**
     * This will create an empty graph of vertices
     * @param vertices input number of vertices
     */
    @SuppressWarnings("unchecked")
    public DiGraph(final int vertices) {
        if (vertices < 0) {
            throw new IllegalArgumentException(String.format("Invalid number of vertices : %d", vertices));
        }
        this.vertices = vertices;
        edges = 0;
        adjacentVertices = new List[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacentVertices[i] = new LinkedList<>();
        }
        inDegree = new int[vertices];
    }

    /**
     * This will create a directed graph from input
     * @param input input describing the graph
     */
    public DiGraph(@NotNull final Input input) {
        this(input.readInt());
        final int numberOfEdges = input.readInt();
        for (int i = 0; i < numberOfEdges; i++) {
            int source = input.readInt();
            int destination = input.readInt();
            addEdge(source, destination);
        }
    }

    /**
     * This will add a directed edge from source to destination
     * @param source source vertex
     * @param destination destination vertex
     */
    public void addEdge(final int source, final int destination) {
        validateVertex(source);
        validateVertex(destination);
        adjacentVertices[source].add(destination);
        edges++;
        inDegree[destination]++;
    }

    /**
     * This will validate input vertex i.e it should not be less than 0 or greater than equal to {@link #vertices}
     * @param vertex vertex
     */
    private void validateVertex(final int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException(String.format("Invalid vertex %d", vertex));
        }
    }

    /**
     * This will return the list of adjacent vertices to given vertex
     * @param source given input vertex
     * @return list of adjacent vertices to given vertex
     */
    @NotNull
    public Iterable<Integer> getAdjacentVertices(final int source) {
        validateVertex(source);
        return adjacentVertices[source];
    }

    /**
     * This will return the number of vertices
     * @return number of vertices
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * This will return the number of edges
     * @return number of edges
     */
    public int getEdges() {
        return edges;
    }

    /**
     * This will return in degree of given vertex
     * @param vertex vertex for which in degree is needed
     * @return in degree of given vertex
     */
    public int getInDegree(final int vertex) {
        validateVertex(vertex);
        return inDegree[vertex];
    }

    /**
     * This will return out degree of given vertex
     * @param vertex vertex for which out degree is needed
     * @return out degree of given vertex
     */
    public int getOutDegree(final int vertex) {
        validateVertex(vertex);
        return adjacentVertices[vertex].size();
    }

    /**
     * This will return string representation of graph
     * @return string representation of graph
     */
    @NotNull
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getVertices(); i++) {
            builder.append(i).append(" - ");
            for (int j : adjacentVertices[i]) {
                builder.append(j).append(' ');
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    /**
     * This will return reverse graph of current graph
     * @return reversed {@link DiGraph}
     */
    @NotNull
    public DiGraph reverse() {
        final DiGraph temp = new DiGraph(vertices);
        for (int v = 0; v < vertices; v++) {
            for (int w : getAdjacentVertices(v)) {
                temp.addEdge(w, v);
            }
        }
        return temp;
    }

}
