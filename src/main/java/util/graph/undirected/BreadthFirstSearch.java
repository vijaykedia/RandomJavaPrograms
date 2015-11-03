package util.graph.undirected;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Input;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by vijaykedia on 02/11/15.
 * Breadth first search implementation of graph
 */
public class BreadthFirstSearch {

    private final Queue<Integer> queue;
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int[] distance;
    private final int source;

    public BreadthFirstSearch(@NotNull final Graph graph, final int source) {
        this.source = source;
        queue = new ArrayDeque<>();

        marked = new boolean[graph.getVertices()];
        Arrays.fill(marked, false);

        edgeTo = new int[graph.getVertices()];

        distance = new int[graph.getVertices()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        search(graph, this.source);
    }

    private void search(@NotNull final Graph graph, final int source) {
        queue.add(source);
        marked[source] = true;
        distance[source] = 0;
        while (!queue.isEmpty()) {
            final int temp = queue.remove();
            for (final int i : graph.getAdjacentVertices(temp)) {
                if (!marked[i]) {
                    queue.add(i);
                    marked[i] = true;
                    edgeTo[i] = temp;
                    distance[i] = distance[temp] + 1;
                }
            }
        }
    }

    public boolean doesPathExist(final int destination) {
        return marked[destination];
    }

    public int getShortestPathLength(final int destination) {
        return distance[destination];
    }

    @Nullable
    public Iterable<Integer> getShortestPath(final int destination) {
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

    }
}
