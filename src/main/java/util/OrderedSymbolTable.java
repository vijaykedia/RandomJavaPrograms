package util;

import org.jetbrains.annotations.NotNull;

/**
 * Created by vijaykedia on 22/10/15.
 */
public abstract class OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value>{

    @NotNull
    public abstract Key min();

    @NotNull
    public abstract Key max();

    @NotNull
    public abstract Key floor(Key key);

    public abstract Key ceiling(Key key);

    public abstract int rank(Key key);

    public abstract Key select(int k);

    public abstract void deleteMin();

    public abstract void deleteMax();

    public abstract int size(Key lo, Key hi);

    public abstract Iterable<Key> keys(Key lo, Key hi);

}
