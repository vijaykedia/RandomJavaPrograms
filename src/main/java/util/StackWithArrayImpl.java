package util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by vijaykedia on 19/10/15.
 * Stack with Array as underlying implementation which can be easily changed to ArrayList if needed
 */
public class StackWithArrayImpl<E> extends Stack<E>{

    @NotNull
    private final E[] elements;
    private int current;

    private static final int DEFAULT_SIZE = 100;

    public StackWithArrayImpl() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public StackWithArrayImpl(final int size) {
        elements = (E[]) new Object[size];
        current = -1;
    }

    public void push(final E item) {
        if (current == elements.length - 1) {
            throw new RuntimeException("Stack does not have more space to store elements. Stack overflow");
        }
        elements[++current] = item;
    }

    public E pop() {
        if (current == -1) {
            throw new RuntimeException("There is no element to remove. Stack underflow");
        }
        final E temp = elements[current];
        elements[current--] = null;
        return temp;
    }

    public E peek() {
        return elements[current];
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    public int search(@Nullable final Object o) {
        if (o != null) {
            @SuppressWarnings("unchecked") final E temp = (E) o;
            for (int i = current; i >= 0; i--) {
                if (temp.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
}
