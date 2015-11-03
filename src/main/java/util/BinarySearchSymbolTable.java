package util;

import org.jetbrains.annotations.NotNull;

/**
 * Created by vijaykedia on 22/10/15.
 */
public abstract class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> extends OrderedSymbolTable<Key, Value> {

    private static final int DEFAULT_SIZE =  100;

    @NotNull private final Key[] keys;
    @NotNull private final Value[] values;

    private int N;

    public BinarySearchSymbolTable() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public BinarySearchSymbolTable(final int size) {
        keys = (Key[]) new Comparable[size];
        values = (Value[]) new Object[size];
    }

    public Value get(@NotNull final Key key, @NotNull final Value value) {
        return null;
    }

    public int size() {
        return N;
    }


}
