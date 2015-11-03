package util.graph.undirected;

import org.jetbrains.annotations.NotNull;
import util.Input;
import util.Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by vijaykedia on 02/11/15.
 * This will be graph api implementation using adjacency matrix as underlying data structure
 */
public class AdjacencyMatrixGraph {

    private final boolean[][] matrix;
    private final int vertices;
    private int edges;

    public AdjacencyMatrixGraph(final int vertices) {
        this.vertices = vertices;
        edges = 0;
        matrix = new boolean[vertices][vertices];
    }

    public AdjacencyMatrixGraph(@NotNull final Input input) {
        this(input.readInt());
        final int numberOfEdges = input.readInt();
        for (int i = 0; i < numberOfEdges; i++) {
            int source = input.readInt();
            int destination = input.readInt();
            addEdge(source, destination);
        }
    }

    public void addEdge(final int source, final int destination) {
        validateVertex(source);
        validateVertex(destination);
        if (!matrix[source][destination]) {
            edges++;
        }
        matrix[source][destination] = true;
        matrix[destination][source] = true;
    }

    private void validateVertex(final int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException(String.format("Invalid vertex %d", vertex));
        }
    }

    @NotNull
    public Iterable<Integer> getAdjacentVertices(final int vertex) {
        validateVertex(vertex);
        return new AdjacencyMatrixIterator(vertex);
    }

    public int getDegree(final int vertex) {
        validateVertex(vertex);
        final Iterable<Integer> iterator = new AdjacencyMatrixIterator(vertex);
        int count = 0;
        for (int i : iterator) {
            count++;
        }
        return count;
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    @NotNull
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (boolean[] aMatrix : matrix) {
            for (boolean anAMatrix : aMatrix) {
                builder.append(anAMatrix ? 1 : 0);
                builder.append(" ");
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    private class AdjacencyMatrixIterator implements Iterator<Integer>, Iterable<Integer> {

        private final int vertex;
        private int temp;

        public AdjacencyMatrixIterator(final int vertex) {
            this.vertex = vertex;
            temp = 0;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (temp < vertices) {
                if (matrix[vertex][temp]) {
                    return true;
                }
                temp++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return temp++;
        }
    }

    public static void main(@NotNull final String[] args) {
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
        AdjacencyMatrixGraph G = new AdjacencyMatrixGraph(new Input(new ByteArrayInputStream(sampleInput.getBytes(StandardCharsets.UTF_8))));
        try {
            final Output output = new Output();
            output.print(G.toString());
            for (final int temp : G.getAdjacentVertices(0)) {
                output.print(temp);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
