package util.graph.directed;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by vijaykedia on 02/11/15.
 * Depth first implementation for Digraph
 */
public class DepthFirstSearch {

    private final int source;
    private final boolean[] marked;
    private final int[] edgeTo;

    public DepthFirstSearch(@NotNull final DiGraph graph, final int source) {
        this.source = source;

        marked = new boolean[graph.getVertices()];
        Arrays.fill(marked, false);

        edgeTo = new int[graph.getVertices()];
        Arrays.fill(edgeTo, 0);
        search(graph, source);
    }

    private void search(@NotNull final DiGraph graph, final int source) {
        marked[source] = true;
        for (final int temp : graph.getAdjacentVertices(source)) {
            if (!marked[temp]) {
                search(graph, temp);
                edgeTo[temp] = source;
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
}
