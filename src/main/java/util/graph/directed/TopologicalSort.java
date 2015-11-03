package util.graph.directed;

import org.jetbrains.annotations.NotNull;

/**
 * Created by vijaykedia on 02/11/15.
 * Topological sort implementation with constraint being no cycles should be there
 */
public class TopologicalSort {

    private final boolean[] marked;

    public TopologicalSort(@NotNull final DiGraph graph) {
        marked = new boolean[graph.getVertices()];

    }

    private void search(@NotNull final DiGraph graph, final int source) {

    }
}
