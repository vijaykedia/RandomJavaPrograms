package util;

/**
 * Created by vijaykedia on 20/10/15.
 * Abstract Stack class
 */
public abstract class Stack<E> {

    public abstract void push( final E item);

    public abstract E pop();

    public abstract E peek();

    public abstract boolean isEmpty();

    public abstract int search(final Object o);
}
