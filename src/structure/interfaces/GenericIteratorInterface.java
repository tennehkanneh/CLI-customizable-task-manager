package src.structure.interfaces;

/**
 * @author Tenneh Kanneh
 * Date: Fri Aug  1 18:48:50 MDT 2025
 * 
 * A generic iterator interface for traversing elements in a data structure.
 *
 * @param <T> the type of elements returned by this iterator
 */
public interface GenericIteratorInterface<T> {

    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if there are more elements to iterate over
     */
    boolean hasNext();

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    T next();

    /**
     * Removes from the underlying collection the last element returned by this iterator.
     * Can be called only once per call to {@code next()}.
     *
     * @throws IllegalStateException if the next method has not yet been called,
     *         or the remove method has already been called after the last call to next
     */
    void remove();
}
