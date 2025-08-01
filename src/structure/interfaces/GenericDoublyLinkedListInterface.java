package src.structure.interfaces;

/**
 * A generic interface for a doubly linked list data structure.
 *
 * @param <T> the type of elements held in this list
 */
public interface GenericDoublyLinkedListInterface<T> {

    /**
     * Adds an item to the front of the list.
     *
     * @param item the item to be added
     */
    void addFirst(T item);

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to be added
     */
    void addLast(T item);

    /**
     * Removes the first occurrence of the specified item from the list.
     *
     * @param item the item to remove
     * @return true if removal was successful, false otherwise
     */
    boolean remove(T item);

    /**
     * Gets the item at the specified index.
     *
     * @param index the index to get
     * @return the item at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    T get(int index);

    /**
     * Returns true if the list contains the specified item.
     *
     * @param item the item to check
     * @return true if found, false otherwise
     */
    boolean contains(T item);

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    int size();

    /**
     * Checks whether the list is empty.
     *
     * @return true if empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all elements from the list.
     */
    void clear();
}
