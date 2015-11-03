package util.graph.directed;

import org.jetbrains.annotations.NotNull;
import util.Input;

/**
 * Created by vijaykedia on 02/11/15.
 */
public class AdjacencyMatrixDiGraph {

    private final int vertices;
    private int edges;

    private final boolean[][] matrix;

    public AdjacencyMatrixDiGraph(final int vertices) {
        this.vertices = vertices;
        edges = 0;
        matrix = new boolean[vertices][vertices];
    }

    public AdjacencyMatrixDiGraph(@NotNull final Input input) {
        this(input.readInt());
    }
}
