package src.structure.interfaces;

/**
 * A generic interface for a stack data structure (LIFO - Last In First Out).
 *
 * @param <T> the type of elements held in this stack
 */
public interface GenericStackInterface<T> {

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param item the item to be pushed
     */
    void push(T item);

    /**
     * Removes and returns the item at the top of the stack.
     *
     * @return the item removed from the top
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    T pop();

    /**
     * Returns the item at the top without removing it.
     *
     * @return the item at the top
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    T peek();

    /**
     * Checks whether the stack is empty.
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return the size of the stack
     */
    int size();

    /**
     * Removes all elements from the stack.
     */
    void clear();
}
