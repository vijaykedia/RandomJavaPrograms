package util;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by vijaykedia on 19/10/15.
 * Stack with {@link java.util.LinkedList} as underlying implementation
 */
public class StackWithLinkedListImpl<E> extends Stack<E> {

    @NotNull
    private final List<E> elements;
    private int size;

    private static final int DEFAULT_SIZE = 100;

    public StackWithLinkedListImpl() {
        this(DEFAULT_SIZE);
    }

    public StackWithLinkedListImpl(final int size) {
        elements = new LinkedList<E>();
    }

    public void push(final E item) {

    }

    @NotNull
    public E pop() {
        return null;
    }

    @NotNull
    public E peek() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int search(final Object item) {
        return 0;
    }
}
