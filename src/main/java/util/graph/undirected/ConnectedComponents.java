package util.graph.undirected;

import org.jetbrains.annotations.NotNull;
import util.Input;
import util.Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by vijaykedia on 02/11/15.
 * Compute connected components using depth first search.
 */
public class ConnectedComponents {

    private final boolean[] marked;
    private final int[] id;
    private int count;

    public ConnectedComponents(@NotNull final Graph graph) {
        marked = new boolean[graph.getVertices()];
        Arrays.fill(marked, false);
        id = new int[graph.getVertices()];
        count = 0;
        search(graph);
    }

    private void search(@NotNull final Graph graph) {
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.getVertices(); i++) {
            if (!marked[i]) {
                marked[i] = true;
                id[i] = count++;
                stack.push(i);
                while (!stack.isEmpty()) {
                    final int temp = stack.pop();
                    for (int j : graph.getAdjacentVertices(temp)) {
                        if (!marked[j]) {
                            stack.push(j);
                            marked[j] = true;
                            id[j] = id(i);
                        }
                    }
                }
            }
        }
    }

    public boolean connected(final int v, final int w) {
        return id(v) == id(w);
    }

    public int count() {
        return count;
    }

    public int id(final int v) {
        return id[v];
    }

    public int[] getId() {
        return id;
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
        final ConnectedComponents connectedComponents = new ConnectedComponents(graph);
        try {
            final Output output = new Output();
            output.print(Arrays.toString(connectedComponents.getId()));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
