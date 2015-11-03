package util.graph.undirected;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Input;
import util.Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by vijaykedia on 02/11/15.
 * Depth First search implementation of graph
 */
public class DepthFirstSearch {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int source;

    public DepthFirstSearch(@NotNull final Graph graph, final int source) {
        marked = new boolean[graph.getVertices()];
        Arrays.fill(marked, false);

        edgeTo = new int[graph.getVertices()];
        this.source = source;
        search(graph, this.source);
    }

    private void search(@NotNull final Graph graph, final int source) {
        marked[source] = true;
        for (final int i : graph.getAdjacentVertices(source)) {
            if (!marked[i]) {
                search(graph, i);
                edgeTo[i] = source;
            }
        }
    }

    public boolean doesPathExist(final int destination) {
        return marked[destination];
    }

    @Nullable
    public Iterable<Integer> getPath(final int destination) {
        if (!doesPathExist(destination)) {
            return null;
        }
        final Stack<Integer> path = new Stack<>();
        for (int temp = destination; temp != source; temp = edgeTo[temp]) {
            path.push(temp);
        }
        path.push(source);
        return path;
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
        final Graph graph = new Graph(new Input(new ByteArrayInputStream(sampleInput.getBytes(StandardCharsets.UTF_8))));
        final DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        try(final Output output = new Output()) {
            if (depthFirstSearch.doesPathExist(6)) {
                output.print(depthFirstSearch.doesPathExist(6));
                final Iterable<Integer> path = depthFirstSearch.getPath(6);
                if (path != null) {
                    for (final int i : path) {
                        output.print(i);
                    }
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
