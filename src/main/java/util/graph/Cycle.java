package util.graph;

import org.jetbrains.annotations.NotNull;
import util.graph.undirected.Graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by vijaykedia on 02/11/15.
 * This will determine if there is any cycle in the graph
 */
public class Cycle {

    private final boolean[] marked;
    private final Stack<Integer> cyclicPath;

    public Cycle(@NotNull final Graph graph) {
        marked = new boolean[graph.getVertices()];
        Arrays.fill(marked, false);

        cyclicPath = new Stack<>();

        for (int i = 0, vertices = graph.getVertices(); i < vertices; i++) {
            search(graph, i);
        }
    }

    private void search(@NotNull final Graph graph, final int source) {
        marked[source] = true;
        for (final int temp : graph.getAdjacentVertices(source)) {
            if (!marked[temp]) {
                search(graph, temp);
            }
        }
    }

    @NotNull
    public Iterable<Integer> getCyclicPath() {
        return cyclicPath;
    }

    public boolean hasCycle(@NotNull final Graph graph) {
        if (hasSelfLoop(graph)) {
            return true;
        }
        if (hasParallelEdge(graph)) {
            return true;
        }
        return false;
    }

    private boolean hasSelfLoop(@NotNull final Graph graph) {
        for(int i = 0, vertices = graph.getVertices(); i < vertices; i++) {
            for (final int temp : graph.getAdjacentVertices(i)) {
                if (i == temp) {
                    cyclicPath.push(temp);
                    cyclicPath.push(temp);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasParallelEdge(@NotNull final Graph graph) {
        return false;
    }
}
