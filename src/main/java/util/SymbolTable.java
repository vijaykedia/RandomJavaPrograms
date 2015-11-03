package util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by vijaykedia on 20/10/15.
 */
public abstract class SymbolTable<Key, Value> {

    public SymbolTable() {}

    public abstract void put(@NotNull final Key key, @NotNull final Value value);

    @Nullable
    public abstract Value get(@NotNull final Key key);

    public abstract void delete(@NotNull final Key key);

    public abstract boolean contains(@NotNull final Key key);

    public abstract boolean isEmpty();

    public abstract int size();

    @NotNull
    public abstract Iterable<Key> keys();
}
