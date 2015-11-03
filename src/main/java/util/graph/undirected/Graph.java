package util.graph.undirected;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Input;
import util.Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vijaykedia on 31/10/15.
 * This will be adjacency list representation of graph
 */
public class Graph {

    private final int vertices;
    @NotNull private final List<Integer>[] adj;

    private int edges;

    /**
     * creates an empty graph of V vertices
     * @param vertices number of vertices
     */
    @SuppressWarnings("unchecked")
    public Graph(final int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adj = new List[vertices];
        for (int i = 0; i < getVertices(); i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * This will create the graph from inputs
     * @param input input stream
     */
    public Graph(@NotNull final Input input) {
        this(input.readInt());
        final int numberOfEdges = input.readInt();
        for (int i = 0; i < numberOfEdges; i++) {
            int source = input.readInt();
            int destination = input.readInt();
            addEdge(source, destination);
        }
    }

    /**
     * This will add an edge between source and destination
     * @param source source i.e one end of edge
     * @param destination destination i.e another end of edge
     */
    public void addEdge(final int source, final int destination) {
        validateVertex(source);
        validateVertex(destination);
        adj[source].add(destination);
        adj[destination].add(source);
        edges++;
    }

    /**
     * This will return the list of adjacent vertices
     * @param vertex vertex for which adjacent list is required
     * @return list of adjacent vertices
     */
    @NotNull
    public Iterable<Integer> getAdjacentVertices(final int vertex) {
        validateVertex(vertex);
        return adj[vertex];
    }

    /**
     * This will return the number of vertices
     * @return number of vertices
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * This will return the number of Edges
     * @return number of edges
     */
    public int getEdges() {
        return edges;
    }

    public int getDegree(final int vertex) {
        validateVertex(vertex);
        return adj[vertex].size();
    }

    /**
     * This will ensure that vertex in question is valid i.e in range of vertices
     * @param vertex input vertex
     */
    private void validateVertex(final int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException(String.format("Invalid vertex %d", vertex));
        }
    }

    /**
     * This will return the string representation of the graph
     * @return adjacency list representation of graph
     */
    @NotNull
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getVertices(); i++) {
            builder.append(i).append(" - ");
            for (int j : adj[i]) {
                builder.append(j).append(' ');
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    public static void main(@Nullable final String[] args) throws IOException {
        final String sampleInput = "13\n" +
                "13\n" +
                "0 5\n" +
                "4 3\n" +
                "0 1\n" +
                "9 12\n" +
                "6 4\n" +
                "5 4\n" +
                "0 2\n" +
                "11 12\n" +
                "9 10\n" +
                "0 6\n" +
                "7 8\n" +
                "9 11\n" +
                "5 3";
        Graph G = new Graph(new Input(new ByteArrayInputStream(sampleInput.getBytes(StandardCharsets.UTF_8))));
        final Output output = new Output();
        output.print(G.toString());
        output.close();
    }
}
